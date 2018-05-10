package pit.springproject.tables;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pit.springproject.tables.controllers.BuyerController;
import pit.springproject.tables.service.buyer.BuyerService;

@SpringBootApplication
public class TablesApplication {

	public static void main(String[] args) {
		SpringApplication.run(TablesApplication.class, args);
	}
}
