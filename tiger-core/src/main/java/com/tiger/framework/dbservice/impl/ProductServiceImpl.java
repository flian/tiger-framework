package com.tiger.framework.dbservice.impl;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.tiger.framework.dao.ProductMapper;
import com.tiger.framework.dao.SKUMapper;
import com.tiger.framework.datamodel.Product;
import com.tiger.framework.datamodel.SKU;
import com.tiger.framework.dbservice.IProductService;
import com.tiger.framework.dto.CartDTO;
import com.tiger.framework.dto.SkuListDTO;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by foy on 2016-06-01.
 */
@Service("productService")
public class ProductServiceImpl implements IProductService {

    @Resource(name = "frameworkSqlSession")
    private SqlSession frameworkSqlSession;


    private static final Logger LOGGER = Logger.getLogger(ProductServiceImpl.class);

    @Override
    public List<Product> listProducts(PageBounds pg,String q) {
        ProductMapper productMapper=frameworkSqlSession.getMapper(ProductMapper.class);
        return productMapper.listProducts(pg,q);
    }
    public Product get(long productId){
         ProductMapper productMapper=frameworkSqlSession.getMapper(ProductMapper.class);
        return productMapper.selectByPrimaryKey(productId);

    }
    public SKU getSku(long skuId){
        SKUMapper skuMapper=frameworkSqlSession.getMapper(SKUMapper.class);
        return skuMapper.selectByPrimaryKey(skuId);
    }
    @Transactional
    public boolean delSku(long skuId){
        SKUMapper skuMapper=frameworkSqlSession.getMapper(SKUMapper.class);
        skuMapper.deleteByPrimaryKey(skuId);
        return true;
    }

    @Override
    public List<SKU> listSkuByProductId(long productId) {
        SKUMapper skuMapper=frameworkSqlSession.getMapper(SKUMapper.class);
        return skuMapper.listSkusByProductId(productId);
    }

    @Transactional
    public boolean insertOrUpdateProduct(Product product){
        ProductMapper productMapper=frameworkSqlSession.getMapper(ProductMapper.class);
        int result = 0;
        if(product.getId() == null || product.getId() == -1){
            product.setId(null);
            result= productMapper.insertSelective(product);
        }else{
            result= productMapper.updateByPrimaryKeySelective(product);
        }
        return result > 0 ? true:false;
    }

    @Transactional
    public boolean insertOrUpdateSKU(SKU sku){
        SKUMapper skuMapper=frameworkSqlSession.getMapper(SKUMapper.class);
        int result=0;
        if(sku.getId() ==null || sku.getId() == -1){
            sku.setId(null);
            result= skuMapper.insertSelective(sku);
        }else{
            result= skuMapper.updateByPrimaryKeySelective(sku);
        }
        return result > 0 ? true:false;
    }
    
	@Override
	public List<SkuListDTO> selectSkuListDTO(PageBounds pg,Long productId) {
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("productId", productId);
		List<SkuListDTO> dto = frameworkSqlSession.selectList("com.tiger.framework.dao.ProductMapper.selectSkuListDTO", params, pg);
		return dto;
	}
	
	@Override
	public List<CartDTO> getCart(Map<Long, Integer> carts) {
		List<CartDTO> resdata = new ArrayList<CartDTO>();
		if(!carts.isEmpty()){
			Map<String,Object> params = new HashMap<String,Object>();
			params.put("carts", carts);
			List<SKU> skulist = frameworkSqlSession.selectList("com.tiger.framework.dao.SKUMapper.getCart", params);
			for(SKU sku : skulist){
				CartDTO dto = new CartDTO();
				dto.setSku(sku);
				dto.setBuyNum(carts.get(sku.getId()));
				resdata.add(dto);
			}
		}
		return resdata;
	}
}
