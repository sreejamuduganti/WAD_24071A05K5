import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class DonorEligibilityServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int age = Integer.parseInt(request.getParameter("age"));
        double weight = Double.parseDouble(request.getParameter("weight"));

        boolean eligible = age >= 18 && age <= 65 && weight >= 50;

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html><html><head><title>Result</title>");
        out.println("<link rel='stylesheet' href='style.css'></head><body>");
        out.println("<div class='container'>");
        out.println("<h2>Eligibility Result</h2>");
        out.println("<p class='subtitle'>Based on the information you provided</p>");

        out.println("<div class='info-row'>Age: <span>" + age + " years</span></div>");
        out.println("<div class='info-row'>Weight: <span>" + weight + " kg</span></div>");

        if (eligible) {
            out.println("<div class='result-box eligible'>You are ELIGIBLE to donate blood!</div>");
        } else {
            out.println("<div class='result-box not-eligible'>You are NOT ELIGIBLE to donate blood.</div>");
            if (age < 18)    out.println("<p class='reason'>Age must be at least 18 years.</p>");
            if (age > 65)    out.println("<p class='reason'>Age must not exceed 65 years.</p>");
            if (weight < 50) out.println("<p class='reason'>Weight must be at least 50 kg.</p>");
        }

        out.println("<a href='index.html' class='back-btn'>Go Back</a>");
        out.println("</div></body></html>");
    }
}
