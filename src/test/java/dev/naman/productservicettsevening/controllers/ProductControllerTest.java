//package dev.naman.productservicettsevening.controllers;
//
//import dev.naman.productservicettsevening.services.SelfProductService;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//
////@SpringBootTest
//class ProductControllerTest {
////    @Autowired
////    private ProductController productController;
////
//////    @MockBean
////    @MockBean
////    private SelfProductService productService;
////
////    @Test
////    void testAbsShouldReturnCorrectValue() {
//////        int i = Math.abs(-2);
//////
//////        assert(i == 2);
////
////            assertFalse(true);
////            // asserFalse(condition)
////        //  assert condition == false
////    }
////
////    @Test
////    public void testArrayIsSortedCorrectly() {
////        int[] l = {1, 2, 3, 6, 5};
////
////        Arrays.sort(l);
////        assertArrayEquals(new int[]{1, 2, 3, 5, 6}, l);
//////        assert l[4] == 6;
//////        assert l[3] == 5;
////
////        int[] l1 = {1, 2, 3, 5, 6};
////
//////        assertArrayEquals(x, l);
////    }
////// don't repeat the business logic in the test case
////    // use values that you know and compare against those
////    // Don't compute the expected value
////
////
//////    @Test        List<Product> p = new ArrayList<>();
////    //        Product p1 = new Product();
//////        p1.setPrice(109.95);
//////        p.add(p1);
//////
//////        when(productService.getAllProducts()).thenReturn(p);
//////
//////        List<Product> products = productController.getAllProducts("1234").getBody();
////////
//////////        assert products.get(0).getPrice() == 109.95;
////////
////////        assertEquals(109.95, products.get(0).getPrice());
////////        assertTrue(products.get(0).getPrice() == 109.95);
////////        assert products.get(0).getPrice() == 109.95;
//////
//////        // 1. Pick the data that you want to validate
//////        // 2. Call the different validations that you want to do
//////
//////        assertThat(products.get(0).getPrice())
//////                .isEqualTo(109.95)
//////                .isGreaterThan(100)
//////                .isLessThan(100)
//////                .isPositive();
//////
//////        assertThat("hello")
//////                .isEqualTo("hi");
////    void getAllProductsShouldReturnEmptyListWhenNoProduct() {
//////        ProductService productService = new SelfProductService();
//////        ProductRepository productRepository = new Po
//////        ProductController productController = new ProductController(productService)
//////
//////        assertThat(new Object())
//////                .isInstanceOf(ProductRepository.class)
////
////
////    }
////    // Why can it fail:
////    // 1. Bug in product service
////    // 2. Bug be in the controller
//
//}
//
//// 1. Test is nothing but a method
//// 2. By default a test always succeeds
//// 3. Unless you put a condition that becomes untrue
////    you check for something that is not as per your expectations
//// 4. A test case fails if a condition given in Assert is untrue
//// Name of a test case method can be:
////    test{What}should{doWhat}
//
////     testGives0ForAllEqualHeights() {}

package dev.naman.productservicettsevening.controllers;

import dev.naman.productservicettsevening.models.Product;
import dev.naman.productservicettsevening.services.SelfProductService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
        import static org.mockito.Mockito.when;

@SpringBootTest
class ProductControllerTest {

    @Autowired
    private ProductController productController;

    @MockBean
    private SelfProductService productService;

    @Test
    void testAbsShouldReturnCorrectValue() {
        int i = Math.abs(-2);
        assertEquals(2, i);
    }

    @Test
    public void testArrayIsSortedCorrectly() {
        int[] l = {1, 2, 3, 6, 5};

        Arrays.sort(l);
        assertArrayEquals(new int[]{1, 2, 3, 5, 6}, l);
    }

    @Test
    void getAllProductsShouldReturnEmptyListWhenNoProduct() {
        List<Product> p = new ArrayList<>();
        when(productService.getAllProducts()).thenReturn(p);

        List<Product> products = productController.getAllProducts("1234",1L).getBody();
        assertThat(products).isEmpty();

        // Additional assertions for empty list scenario
        assertTrue(products.isEmpty());
        assertEquals(0, products.size());
    }

    @Test
    void getAllProductsShouldReturnProductsList() {
        List<Product> p = new ArrayList<>();
        Product p1 = new Product();
        p1.setPrice(109.95);
        p.add(p1);

        when(productService.getAllProducts()).thenReturn(p);

        List<Product> products = productController.getAllProducts("123",1L).getBody();
        assertThat(products).isNotEmpty();
        assertThat(products.get(0).getPrice()).isEqualTo(109.95);

        // Additional assertions for non-empty product list
        assertEquals(1, products.size());
        assertEquals(109.95, products.get(0).getPrice());

        // Assert price is greater than 100 and positive
        assertThat(products.get(0).getPrice())
                .isEqualTo(109.95)
                .isGreaterThan(100)
                .isPositive();
    }

    @Test
    void testStringAssertions() {
        assertThat("hello").isEqualTo("hello");
        assertThat("hello").isNotEqualTo("hi");
    }

    @Test
    void testInstanceCheck() {
        assertThat(new Object()).isNotInstanceOf(Product.class);
    }
}
