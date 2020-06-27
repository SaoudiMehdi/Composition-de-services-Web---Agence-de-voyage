package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Beans.Car;
import org.hibernate.Session;
import utility.HibernateUtil;

public class CarsDAO {
	
	/*
	 * Thoses are the attributes of Problems DAO	
	 */
	public static ArrayList<Car> CARS = new ArrayList<Car>(); 
	private static Connection connection;
	private static Statement statement;
	private static PreparedStatement preparedStatement;
	private static String requette;
			
	
			
		
		/*
		 * This function returns closed problems
		 */
		public  ArrayList<Car> getCars(String city, String checkIn, String checkOut)  {
			CARS.clear();
			String city_intermidiare = "Rabat";
			if(city!=null && (city.equalsIgnoreCase("Rabat") || city.equalsIgnoreCase("Paris"))){
				city_intermidiare = city;
			}
			Session session = HibernateUtil.getSessionJavaConfigFactory().openSession();
			CARS = (ArrayList<Car>) session.createQuery("from Car where city = :city order by rating DESC").setParameter("city",city_intermidiare).list();

			changeDaysAndTotalPrice(checkIn, checkOut);
			/*ResultSet resultat = null;

			try {
					connection = ConnectionFactory.getConnection();
					if(connection==null) return null;
					preparedStatement = connection.prepareStatement(requette);
					preparedStatement.setString(1, city_intermidiare);
					resultat = preparedStatement.executeQuery();
					int day_number = getDaysNumber(checkIn, checkOut);
					int nombreLigne = 0;
					/*while(resultat.next() ){
						int  price_per_duration = Integer.parseInt(resultat.getString("price_per_day"))*day_number;
						CARS.add(new Car(resultat.getString("brand"), resultat.getString("city"), resultat.getString("seat_number"), resultat.getString("air_conditioner"), resultat.getString("rating"),
								resultat.getString("image_link"), String.valueOf(price_per_duration/10),day_number));
						nombreLigne++;
					}
				
					preparedStatement.close();
					resultat.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
			return CARS;
		}

	private void changeDaysAndTotalPrice( String checkIn, String checkOut) {
		int day_number = getDaysNumber(checkIn, checkOut);
		for (int i=0; i<CARS.size();i++){
			CARS.get(i).setDay_number(day_number);
			int  price_per_duration = Integer.parseInt(CARS.get(i).getPrice_per_duration())*day_number;
			CARS.get(i).setPrice_per_duration(String.valueOf(price_per_duration/10));
		}
	}

	public static int getDaysNumber(String checkIn, String checkOut) {
			Integer[] split1 = splitter(checkIn);
			Integer[] split2 = splitter(checkOut);
			int diff_year = (split2[0]-split1[0])*365;
			int diff_month = (split2[1]-split1[1])*30;
			int diff_day = (split2[2]-split1[2]);
			
			return diff_year+diff_month+diff_day;
		}
		
		public static Integer[] splitter(String datetosplit){
		    Integer[] date_splitted = new Integer[3];
		    String[] split1 = datetosplit.split("-",2);
		    String[] split2 = split1[1].split("-",2);
		    date_splitted[0] = Integer.parseInt(split1[0]); //year
		    date_splitted[1] = Integer.parseInt(split2[0]); //month
		    date_splitted[2] = Integer.parseInt(split2[1]); //day
		    
		    return date_splitted;
		}

		

}
