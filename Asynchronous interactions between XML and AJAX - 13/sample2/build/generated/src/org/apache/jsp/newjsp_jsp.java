package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class newjsp_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <script>\n");
      out.write("        function loadOrders() {\n");
      out.write("\n");
      out.write("            var xhttp = new XMLHttpRequest();\n");
      out.write("\n");
      out.write("            xhttp.onreadystatechange = function () {\n");
      out.write("\n");
      out.write("                if (this.readyState == 4 && this.status == 200) {\n");
      out.write("\n");
      out.write("                    var xml = this.responseXML;\n");
      out.write("\n");
      out.write("                    var orders = xml.getElementsByTagName(\"order\");\n");
      out.write("\n");
      out.write("                    var output = \"<h2>Order Details</h2>\";\n");
      out.write("\n");
      out.write("                    output += \"<table border='1' cellpadding='10'>\";\n");
      out.write("                    \n");
      out.write("                    output += \"<tr>\";\n");
      out.write("                    output += \"<th>ID</th>\";\n");
      out.write("                    output += \"<th>Customer</th>\";\n");
      out.write("                    output += \"<th>Product</th>\";\n");
      out.write("                    output += \"<th>Quantity</th>\";\n");
      out.write("                    output += \"<th>Price</th>\";\n");
      out.write("                    output += \"</tr>\";\n");
      out.write("\n");
      out.write("                    for (var i = 0; i < orders.length; i++) {\n");
      out.write("\n");
      out.write("                        var id =\n");
      out.write("                            orders[i].getElementsByTagName(\"id\")[0]\n");
      out.write("                            .childNodes[0].nodeValue;\n");
      out.write("\n");
      out.write("                        var customer =\n");
      out.write("                            orders[i].getElementsByTagName(\"customer\")[0]\n");
      out.write("                            .childNodes[0].nodeValue;\n");
      out.write("\n");
      out.write("                        var product =\n");
      out.write("                            orders[i].getElementsByTagName(\"product\")[0]\n");
      out.write("                            .childNodes[0].nodeValue;\n");
      out.write("\n");
      out.write("                        var quantity =\n");
      out.write("                            orders[i].getElementsByTagName(\"quantity\")[0]\n");
      out.write("                            .childNodes[0].nodeValue;\n");
      out.write("\n");
      out.write("                        var price =\n");
      out.write("                            orders[i].getElementsByTagName(\"price\")[0]\n");
      out.write("                            .childNodes[0].nodeValue;\n");
      out.write("\n");
      out.write("                        output += \"<tr>\";\n");
      out.write("\n");
      out.write("                        output += \"<td>\" + id + \"</td>\";\n");
      out.write("                        output += \"<td>\" + customer + \"</td>\";\n");
      out.write("                        output += \"<td>\" + product + \"</td>\";\n");
      out.write("                        output += \"<td>\" + quantity + \"</td>\";\n");
      out.write("                        output += \"<td>\" + price + \"</td>\";\n");
      out.write("\n");
      out.write("                        output += \"</tr>\";\n");
      out.write("                    }\n");
      out.write("\n");
      out.write("                    output += \"</table>\";\n");
      out.write("\n");
      out.write("                    document.getElementById(\"orderData\").innerHTML = output;\n");
      out.write("                }\n");
      out.write("            };\n");
      out.write("\n");
      out.write("            xhttp.open(\"GET\", \"orders.xml\", true);\n");
      out.write("\n");
      out.write("            xhttp.send();\n");
      out.write("        }\n");
      out.write("    </script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>Online Shopping - Order Viewer</h1>\n");
      out.write("\n");
      out.write("        <button onclick=\"loadOrders()\">\n");
      out.write("        Load Orders\n");
      out.write("        </button>\n");
      out.write("\n");
      out.write("        <br><br>\n");
      out.write("\n");
      out.write("        <div id=\"orderData\"></div>\n");
      out.write("        </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
