package com.quesito.struts.config;


import org.apache.struts2.dispatcher.filter.StrutsPrepareAndExecuteFilter;
import javax.servlet.annotation.WebFilter;

@WebFilter(filterName = "struts2", urlPatterns = {"/*"})
public class Struts2 extends StrutsPrepareAndExecuteFilter {
}

