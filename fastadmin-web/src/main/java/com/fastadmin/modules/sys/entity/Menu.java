package com.fastadmin.modules.sys.entity;

import com.sun.tools.internal.ws.processor.model.Response;
import lombok.Data;

import java.io.Serializable;
import java.util.Comparator;
import java.util.List;

@Data
public class Menu extends Resource{

    private List<Menu> subMenuList;
}