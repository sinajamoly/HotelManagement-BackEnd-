package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.entity.Rooms;
import com.bussiness.RoomClass;

public final class BookRoom_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>Book Room</h1>\n");
      out.write("        <h1>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope[\"message\"]}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</h1>\n");
      out.write("        ");
      out.write("\n");
      out.write("        <form action=\"BookRoomServlet\" method=\"submit\">\n");
      out.write("            <select name=\"roomCode\" value=\"rooms code\">\n");
      out.write("                ");
 for(Rooms r:rc.listRooms()){
      out.write("\n");
      out.write("                <option>\n");
      out.write("                ");
      out.print(r.getRoomCode() );
      out.write("\n");
      out.write("                </option>\n");
      out.write("        ");
 }  
      out.write("\n");
      out.write("            </select>\n");
      out.write("            \n");
      out.write("            <table border=\"1\">\n");
      out.write("                <tbody>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Check In</td>\n");
      out.write("                        <td><input type=\"date\" name=\"checkIn\" value=\"\" /></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Check Out</td>\n");
      out.write("                        <td><input type=\"date\" name=\"checkOut\" value=\"\" /></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>paid Status</td>\n");
      out.write("                        <td><input type=\"checkbox\" name=\"paid\" value=\"ON\" /></td>\n");
      out.write("                    </tr>\n");
      out.write("                </tbody>\n");
      out.write("            </table>\n");
      out.write("            <input type=\"submit\" value=\"Book the Room\"/>\n");
      out.write("        </form>\n");
      out.write("            \n");
      out.write("            \n");
      out.write("        \n");
      out.write("        <form>\n");
      out.write("            <table border=\"1\">\n");
      out.write("                <thead>\n");
      out.write("                    <tr>\n");
      out.write("                        <th>code</th>\n");
      out.write("                        <th>type</th>\n");
      out.write("                        <th>Capacity</th>\n");
      out.write("                        <th>Location</th>\n");
      out.write("                        <th>Cost</th>\n");
      out.write("                    </tr>\n");
      out.write("                </thead>\n");
      out.write("                <tbody>\n");
      out.write("            ");
 for(Rooms r:rc.listRooms()){
      out.write("\n");
      out.write("                    <tr>\n");
      out.write("                        <td>");
      out.print(r.getRoomCode() );
      out.write("<br/></td>\n");
      out.write("                        <td>");
      out.print(r.getRoomType());
      out.write("<br/></td>\n");
      out.write("                        <td>");
      out.print(r.getRoomCapacity() );
      out.write("<br/></td>\n");
      out.write("                        <td>");
      out.print(r.getRoomLocation() );
      out.write("</td>\n");
      out.write("                        <td>");
      out.print(r.getRoomCost() );
      out.write("</td>\n");
      out.write("                    </tr>\n");
      out.write("            ");
 }  
      out.write("\n");
      out.write("               </tbody>\n");
      out.write("            </table>\n");
      out.write("        </form>\n");
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
