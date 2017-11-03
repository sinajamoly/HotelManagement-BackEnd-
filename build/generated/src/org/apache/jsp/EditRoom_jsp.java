package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.entity.Rooms;
import com.bussiness.RoomClass;

public final class EditRoom_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

 RoomClass rc=new RoomClass();
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
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <form action=\"EditRoomServlet\" method=\"post\">\n");
      out.write("        <h1>Edit Room</h1>\n");
      out.write("            ");
      out.write("\n");
      out.write("            \n");
      out.write("            ");
 for(Rooms r:rc.listRooms()){ 
      out.write("\n");
      out.write("                <br/>\n");
      out.write("                code:\n");
      out.write("                ");
      out.print(r.getRoomCode() );
      out.write("<br/>\n");
      out.write("                type:\n");
      out.write("                ");
      out.print(r.getRoomType());
      out.write("<br/>\n");
      out.write("                Capacity:\n");
      out.write("                ");
      out.print(r.getRoomCapacity() );
      out.write("<br/>\n");
      out.write("                Location:\n");
      out.write("                ");
      out.print(r.getRoomLocation() );
      out.write("<br/>\n");
      out.write("                Cost:\n");
      out.write("                ");
      out.print(r.getRoomCost() );
      out.write("$<br/>\n");
      out.write("                _________________________________            \n");
      out.write("            ");
 } 
      out.write("\n");
      out.write("            <br/>\n");
      out.write("            <h2>Room Code</h2>\n");
      out.write("                <select name=\"roomCode\" value=\"rooms code\">\n");
      out.write("                ");
 for(Rooms r:rc.listRooms()){
      out.write("\n");
      out.write("                <option>\n");
      out.write("                ");
      out.print(r.getRoomCode() );
      out.write("\n");
      out.write("                </option>\n");
      out.write("                ");
 }  
      out.write("\n");
      out.write("            </select>\n");
      out.write("            <br/>\n");
      out.write("            <h2>Room Type</h2>\n");
      out.write("            <select name=\"roomType\">\n");
      out.write("                                <option>Normal</option>\n");
      out.write("                                <option>Excelent</option>\n");
      out.write("                                <option>VIP</option>\n");
      out.write("                                <option>VVIP</option>\n");
      out.write("            </select>\n");
      out.write("            <h2>Room Capacity</h2>\n");
      out.write("            <select name=\"roomCapacity\">\n");
      out.write("                                <option>1</option>\n");
      out.write("                                <option>2</option>\n");
      out.write("                                <option>3</option>\n");
      out.write("                                <option>4</option>\n");
      out.write("                                <option>5</option>\n");
      out.write("            </select>\n");
      out.write("            <h2>Room Location</h2>\n");
      out.write("            <select name=\"roomLocation\">\n");
      out.write("                                <option>Building_one</option>\n");
      out.write("                                <option>Building_Two</option>\n");
      out.write("                                <option>Bulding_Three</option>\n");
      out.write("            </select>\n");
      out.write("            <h2>Room Cost</h2>\n");
      out.write("            <input type=\"text\" name=\"roomCost\"/>\n");
      out.write("            <br/>\n");
      out.write("            <input type=\"submit\" value=\"Edit\"/>\n");
      out.write("        </form>\n");
      out.write("            \n");
      out.write("    </body>\n");
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
