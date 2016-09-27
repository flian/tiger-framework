package com.pharmacodia.dg.framework.datamodel;

import com.github.miemiedev.mybatis.paginator.domain.Order;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.Paginator;

/**
 *  分页数据类型
 * <p/>
 * <p><b>User:</b> charles.wang <a href="mailto:charles.wang0@pactera.com">charles.wang0@pactera.com</a></p>
 * <p><b>Date:</b> 2015-01-06 </p>
 *
 * @author charles.wang
 */
public class Pager {
    /**
     * 当前页号：默认值为1
     */
    private int pageNo = 1;
    /**
     * 每页要显示的记录数：默认值为10
     */
    private int pageSize = 10;

    /**
     * 总页数：根据查询结果集计算得出
     */
    private int pageCount;
    /**
     * 总记录数：查询结果集的数量
     */
    private int recordCount;

    /**
     * 当前页的行数起始值：从0开始。(根据页面参数的入参计算得出，用于sql查询)
     */
    private int offset;

    /**
     * @return 当前页的行数起始值
     * @see #offset
     */
    public int getOffset() {
        return (this.pageNo - 1) * this.pageSize;
    }

    /**
     * @return 总页数
     * @see #pageCount
     */
    public int getPageCount() {
        if (this.recordCount == 0) {
            return 0;
        }

        return (this.recordCount + this.pageSize - 1) / this.pageSize;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getRecordCount() {
        return recordCount;
    }

    public void setRecordCount(int recordCount) {
        this.recordCount = recordCount;
    }

    public PageBounds toPageBounds( Order... order){
        PageBounds pg= new PageBounds(pageNo,pageSize,order);
        return  pg;
    }

    public static Pager toPager(Paginator pg){
        Pager pager=new Pager();
        pager.setPageNo(pg.getPage());
        pager.setPageSize(pg.getLimit());
        pager.setRecordCount(pg.getTotalCount());
        return pager;
    }
}
