package co.grandcircus.coffeeshop;

import java.awt.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import co.grandcircus.coffeeshop.dao.ProductsDao;
import co.grandcircus.coffeeshop.dao.UsersDao;
import co.grandcircus.coffeeshop.entity.User;

@Controller
public class CoffeeShopController {

	@Autowired
	private UsersDao usersDao;
	@Autowired
	private ProductsDao productsDao;
	
	@RequestMapping("/")
	public ModelAndView index() {
		return new ModelAndView("index"); 
	}
	
	@RequestMapping("/register")
	public ModelAndView showRegister() {
		return new ModelAndView("register");
	}
	
	@PostMapping("/register")
	public void registerUser(
			@RequestParam("name") String name,
			@RequestParam("email") String email,
			@RequestParam("pw") String pw
			) {
		User a = new User();
		a.setName(name);
		a.setUserName(email);
		a.setPassword(pw);
		
		usersDao.create(a);
		System.out.println(a);
	}
	
	
	
	
}
