package cn.tmsreception.controller;

import cn.tmsreception.entity.Column;
import cn.tmsreception.service.IColumnService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 17921 on 2017/11/25.
 */
@Controller
public class ColumnController {

    @Resource(name = "ColumnService")
    private IColumnService columnService;

    @RequestMapping("/page/showColumnPage")
    public String showColumn(){
        return "/page/role/column.jsp";
    }

    @RequestMapping("/getColumn")
    @ResponseBody
    public Object getColumn(){

        List<Column> columnList = columnService.getColumn();

        //新的容器 保存有父子关系的权限
        List<Column> rootMenus = new ArrayList<Column>();

        //将平级的权限  变成  有层级关系的权限集合

        for (Column item : columnList) {
            Column childMenu = item;
            String code=childMenu.getParentcode();
            if (code.equals("0")) {
                rootMenus.add(item);
            } else {
                for (Column innerMenu : columnList) {
                    String code1=innerMenu.getSyscode();

                    if (code1.equals(code)) {
                        Column parentMenu = innerMenu;
                        parentMenu.getChildren().add(childMenu);
                        break;
                    }
                }
            }
        }



        return rootMenus;
    }


}
