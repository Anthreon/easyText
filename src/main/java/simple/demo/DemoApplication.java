package simple.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		
		  ApplicationContext context = SpringApplication.run(DemoApplication.class, args);
	      JsonFileReaderService jsonFileReaderService = context.getBean(JsonFileReaderService.class);
	        try {
	        	FoodClass foodData = jsonFileReaderService.readJsonFile();

	  		  if (args.length > 0) {
				  for(String argument: args) {
					  if(argument.equals("print")) {
				        	FoodClass.printFormattedData(foodData);
						  break;
					  } else  if(argument.equals("findMax")) {
						  FoodClass.printOverallMax(foodData);
						  break;
					  } else {
						  System.out.println("Use print or findMax argument");
						  break;
					  }
				  }
				  

			  } 
	        	
	        	
	        	
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        

    }
	}


