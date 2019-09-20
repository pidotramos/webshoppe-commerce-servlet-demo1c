package com.webshoppe.ecommerce.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webshoppe.ecommerce.bean.ProductCatalog;
import com.webshoppe.ecommerce.entity.Book;
import com.webshoppe.ecommerce.entity.Flower;
import com.webshoppe.ecommerce.entity.Toy;
import com.webshoppe.ecommerce.jdbc.JdbcConnectionManager;
import com.webshoppe.ecommerce.repository.BookRepository;
import com.webshoppe.ecommerce.repository.FlowerRepository;
import com.webshoppe.ecommerce.repository.ToyRepository;
import com.webshoppe.ecommerce.service.BookCatalogService;
import com.webshoppe.ecommerce.service.FlowerCatalogService;
import com.webshoppe.ecommerce.service.ToyCatalogService;

@WebServlet(loadOnStartup = 1, urlPatterns = "/catalog")
public class ProductCatalogServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private ToyCatalogService toyCatalogService;
    private FlowerCatalogService flowerCatalogService;
    private BookCatalogService bookCatalogService;

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {    	
        final JdbcConnectionManager jdbcConnectionManager = new JdbcConnectionManager();
        final ToyRepository toyRepository = new ToyRepository(jdbcConnectionManager);
        final FlowerRepository flowerRepository = new FlowerRepository(jdbcConnectionManager);
        final BookRepository bookRepository = new BookRepository(jdbcConnectionManager);

        toyCatalogService = new ToyCatalogService(toyRepository);
        bookCatalogService = new BookCatalogService(bookRepository);
        flowerCatalogService = new FlowerCatalogService(flowerRepository);
        
        List<Toy> toys = toyCatalogService.getToyCatalog();
        List<Book> books = bookCatalogService.getBookCatalog();
        List<Flower> flowers = flowerCatalogService.getFlowerCatalog();
        
        ProductCatalog productCatalog = new ProductCatalog();
        productCatalog.setBooks(books);
        productCatalog.setFlowers(flowers);
        productCatalog.setToys(toys);
        
        ServletContext application = servletConfig.getServletContext();
        application.setAttribute("catalog", productCatalog);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	RequestDispatcher dispatcher = request.getRequestDispatcher("/catalog");
    	dispatcher.forward(request, response);
    }
    
}
