package com.tiger.framework.datamodel;

import java.io.Serializable;

public class Product implements Serializable{
    public Product(){

    }
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product.id
     *
     * @mbggenerated Tue May 31 17:27:56 CST 2016
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product.name
     *
     * @mbggenerated Tue May 31 17:27:56 CST 2016
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product.description
     *
     * @mbggenerated Tue May 31 17:27:56 CST 2016
     */
    private String description;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product.parent_category_id
     *
     * @mbggenerated Tue May 31 17:27:56 CST 2016
     */
    private Long parentCategoryId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product.long_description
     *
     * @mbggenerated Tue May 31 17:27:56 CST 2016
     */
    private String longDescription;



    private Boolean onShelf;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product.id
     *
     * @return the value of product.id
     *
     * @mbggenerated Tue May 31 17:27:56 CST 2016
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product.id
     *
     * @param id the value for product.id
     *
     * @mbggenerated Tue May 31 17:27:56 CST 2016
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product.name
     *
     * @return the value of product.name
     *
     * @mbggenerated Tue May 31 17:27:56 CST 2016
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product.name
     *
     * @param name the value for product.name
     *
     * @mbggenerated Tue May 31 17:27:56 CST 2016
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product.description
     *
     * @return the value of product.description
     *
     * @mbggenerated Tue May 31 17:27:56 CST 2016
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product.description
     *
     * @param description the value for product.description
     *
     * @mbggenerated Tue May 31 17:27:56 CST 2016
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product.parent_category_id
     *
     * @return the value of product.parent_category_id
     *
     * @mbggenerated Tue May 31 17:27:56 CST 2016
     */
    public Long getParentCategoryId() {
        return parentCategoryId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product.parent_category_id
     *
     * @param parentCategoryId the value for product.parent_category_id
     *
     * @mbggenerated Tue May 31 17:27:56 CST 2016
     */
    public void setParentCategoryId(Long parentCategoryId) {
        this.parentCategoryId = parentCategoryId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product.long_description
     *
     * @return the value of product.long_description
     *
     * @mbggenerated Tue May 31 17:27:56 CST 2016
     */
    public String getLongDescription() {
        return longDescription;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product.long_description
     *
     * @param longDescription the value for product.long_description
     *
     * @mbggenerated Tue May 31 17:27:56 CST 2016
     */
    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription == null ? null : longDescription.trim();
    }

    public Boolean isOnShelf() {
        return onShelf;
    }

    public void setOnShelf(Boolean onShelf) {
        this.onShelf = onShelf;
    }
}