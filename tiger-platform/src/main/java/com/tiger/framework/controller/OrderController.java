package com.tiger.framework.controller;

import com.github.miemiedev.mybatis.paginator.domain.Order;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.github.miemiedev.mybatis.paginator.domain.Paginator;
import com.tiger.framework.dbservice.IOrderService;
import com.tiger.framework.dto.OrderDTO;
import com.tiger.framework.dto.RESTResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by foy on 2016-06-16.
 */
@Controller
@RequestMapping("/orders")
public class OrderController {

    private  static String [] COLUMNS=new String[]{"order_id","total_money","freight","order_status","order_creater","created_time"};
    @Autowired
    IOrderService orderService;

    @RequestMapping
    public String list(){
        return "/orders/list";
    }


    @RequestMapping("/ajax")
    @ResponseBody
    public Object orderJson(@RequestParam(value = "start") int start,@RequestParam(value = "draw") int draw,
                     @RequestParam(value = "length",defaultValue = "10") int length,
                     @RequestParam(value="search[value]",defaultValue="")String q,
                     @RequestParam(value="order[0][column]",defaultValue="0") int sort,
                     @RequestParam(value="order[0][dir]",defaultValue="asc") String dir){
        DatatablesViewPage rs=new DatatablesViewPage<OrderDTO>();
        int p= start/length + 1 ;
        PageList<OrderDTO> orders= (PageList<OrderDTO>) orderService.queryOrderByKeyandPage(q,new PageBounds(p,length, Order.create(COLUMNS[sort], dir)));
        Paginator page=orders.getPaginator();
        rs.setDraw(draw);
        rs.setRecordsTotal(page.getTotalCount());
        rs.setRecordsFiltered(page.getTotalCount());
        rs.setData(orders);
        return rs;
    }
    @RequestMapping(value = "/{orderId}/audit",method = RequestMethod.POST)
    @ResponseBody
    public Object audit(@PathVariable String orderId,@RequestParam("auditResult") String auditResult,@RequestParam("comment") String auditComment){
        orderService.auditOrder(orderId,auditResult,auditComment);
        RESTResponseDTO rs=new RESTResponseDTO();
        rs.setProcCode(200);
        rs.setMessage("success!");
        return rs;
    }
    @RequestMapping(value="/{orderId}/ship",method = RequestMethod.POST)
    @ResponseBody
    public Object ship(@PathVariable String orderId){
        orderService.shipOrder(orderId);
        RESTResponseDTO rs=new RESTResponseDTO();
        rs.setProcCode(200);
        rs.setMessage("success!");
        return rs;
    }
}
