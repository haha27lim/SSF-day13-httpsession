package sg.edu.nus.iss.app.httpsession.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import sg.edu.nus.iss.app.httpsession.models.Cart;
import sg.edu.nus.iss.app.httpsession.models.Item;
import org.springframework.web.bind.annotation.PostMapping;

// Controller for handling HTTP requests for shopping cart operations
@Controller
@RequestMapping(path="/cart")
public class ShoppingCartController {
    
    // Handles GET request for shopping cart page
    @GetMapping
    public String getCart(Model model, HttpSession session){
        // Retrieve cart from session, or create new cart if not found
        Cart cart = (Cart)session.getAttribute("cart");
        if(null == cart){
            cart = new Cart();
            session.setAttribute("cart",cart);
        }

        // Add new item and cart to model for rendering in the view
        model.addAttribute("item", new Item());
        model.addAttribute("cart", cart);
        
        // name of the template to render
        return "cart";
    }

    // Handles POST request for adding item to shopping cart
    @PostMapping()
    public String postData(Model model, HttpSession session, 
        @Valid Item item, BindingResult bindResult) {
        Cart cart = (Cart)session.getAttribute("cart");
        
        // Check if item has any validation errors
        if(bindResult.hasErrors()){
            model.addAttribute("item", item);
            model.addAttribute("cart", cart);
            // return to the same page if there are errors
            return "cart";
        }

        // Add item to cart and update model for rendering in the view
        cart.addItemToCart(item);
        model.addAttribute("item", item);
        model.addAttribute("cart", cart);
        // name of the template to render
        return "cart";
    }
    
}