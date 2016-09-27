package com.tiger.framework.dbservice;

import java.util.List;
import java.util.Map;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.tiger.framework.datamodel.Product;
import com.tiger.framework.datamodel.SKU;
import com.tiger.framework.dto.CartDTO;
import com.tiger.framework.dto.SkuListDTO;

/**
 * Created by foy on 2016-06-01.
 */
public interface IProductService {
    public List<Product> listProducts(PageBounds pg,String q);
    public List<SKU> listSkuByProductId(long productId);

    boolean insertOrUpdateProduct(Product product);

    Product get(long productId);

    SKU getSku(long skuId);

    boolean insertOrUpdateSKU(SKU sku);

    boolean delSku(long skuId);
    
    public List<SkuListDTO> selectSkuListDTO(PageBounds pg,Long productId);
    
	public List<CartDTO> getCart(Map<Long, Integer> carts);
}
