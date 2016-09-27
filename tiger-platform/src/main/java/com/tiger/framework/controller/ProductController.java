package com.tiger.framework.controller;

import com.github.miemiedev.mybatis.paginator.domain.Order;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.github.miemiedev.mybatis.paginator.domain.Paginator;
import com.tiger.framework.datamodel.Product;
import com.tiger.framework.datamodel.SKU;
import com.tiger.framework.dbservice.ICategoryService;
import com.tiger.framework.dbservice.IProductService;
import com.tiger.framework.dto.RESTResponseDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


/**
 * Created by foy on 2016-06-01.
 */
@Controller
public class ProductController {

    private  static String [] COLUMNS=new String[]{"id","name","description","long_description"};

    @Resource(name="productService")
    IProductService productService;

    @Resource(name="categoryService")
    ICategoryService categoryService;

    @RequestMapping(value = "/products",method = RequestMethod.GET)
    public String listProducts(Model model){
        model.addAttribute("categories",categoryService.all());
        return "/products/list";
    }

    @RequestMapping("/products/ajax")
    @ResponseBody
    public Object productsJson(@RequestParam(value = "start") int start,@RequestParam(value = "draw") int draw,
                               @RequestParam(value = "length",defaultValue = "10") int length,
                               @RequestParam(value="search[value]",defaultValue="")String q,
                               @RequestParam(value="order[0][column]",defaultValue="0") int sort,
                               @RequestParam(value="order[0][dir]",defaultValue="asc") String dir){
        DatatablesViewPage rs=new DatatablesViewPage<Product>();
        int p= start/length + 1 ;
        PageList<Product> products= (PageList<Product>) productService.listProducts(new PageBounds(p,length, Order.create(COLUMNS[sort],dir)),q);
        Paginator page=products.getPaginator();
        rs.setDraw(draw);
        rs.setRecordsTotal(page.getTotalCount());
        rs.setRecordsFiltered(page.getTotalCount());
        rs.setData(products);
        return rs;
    }

    @RequestMapping(value = "/products",method = RequestMethod.POST)
    @ResponseBody
    public Object saveOrUpdateProduct(Product product){
        RESTResponseDTO rs=new RESTResponseDTO();
        rs.setProcCode(200);
       productService.insertOrUpdateProduct(product);
        rs.setMessage("save or update success!");
        return rs;
    }

    @RequestMapping(value = "/products/{productId}",method = RequestMethod.GET)
    @ResponseBody
    public Object productInfo(@PathVariable long productId){
        return productService.get(productId);
    }
    @RequestMapping(value = "/products/{productId}/on",method = RequestMethod.POST)
    @ResponseBody
    public String putOn(@PathVariable long productId){
        Product product=new Product();
        product.setId(productId);
        product.setOnShelf(true);
        productService.insertOrUpdateProduct(product);
        return "";
    }

    @RequestMapping(value = "/products/{productId}/off",method = RequestMethod.POST)
    @ResponseBody
    public String pullOff(@PathVariable long productId){
        Product product=new Product();
        product.setId(productId);
        product.setOnShelf(false);
        productService.insertOrUpdateProduct(product);
        return "";
    }

    @RequestMapping(value = "/products/{productId}/skus",method = RequestMethod.GET)
    public String skuPage(@PathVariable long productId, Model model){
        model.addAttribute("product", productService.get(productId));
        return "/products/skus";
    }

    @RequestMapping(value = "/products/{productId}/skus/ajax",method = RequestMethod.GET)
    @ResponseBody
    public Object productSkus(@PathVariable long productId, Model model){
        return productService.listSkuByProductId(productId);
    }

    @RequestMapping(value = "/products/{productId}/sku/{skuId}",method = RequestMethod.GET)
    @ResponseBody
    public Object skuInfo(@PathVariable  long productId,@PathVariable long skuId, Model model){
        return productService.getSku(skuId);
    }

    /**
     * save/update  sku
     * @return
     */
    @RequestMapping(value = "/products/{productId}/sku",method = RequestMethod.POST)
    @ResponseBody
    public Object saveOrUpdateSku(SKU sku,@PathVariable long productId){
        RESTResponseDTO rs=new RESTResponseDTO();
        rs.setProcCode(200);
        sku.setProductId(productId);
        productService.insertOrUpdateSKU(sku);
        rs.setMessage("save or udapte sku success.");
        return rs;
    }

    @RequestMapping(value = "/products/{productId}/sku/{skuId}/delete",method = RequestMethod.POST)
    @ResponseBody
    public Object deleteSku(@PathVariable long productId, @PathVariable long skuId){
        RESTResponseDTO rs=new RESTResponseDTO();
        rs.setProcCode(200);
        productService.delSku(skuId);
        rs.setMessage("delete sku success.");
        return rs;
    }
}
