/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReportBuilder;

import com.sun.org.apache.regexp.internal.recompile;
import java.util.List;

/**
 *
 * @author Zoran
 */
public class Report {

    private String naslov;
    private List<String> zapisi;

    public Report(ReportBuilder builder) {
        this.naslov=builder.naslov;
        this.zapisi=builder.zapis;
    }

    public void setNaslov(String naslov) {
        this.naslov = naslov;
    }

    public void setZapis(List<String> zapis) {
        this.zapisi = zapis;
    }

    public String getNaslov() {
        return naslov;
    }

    public List<String> getZapis() {
        return zapisi;
    }

    public void ispis() {
        System.out.println(naslov);
     //   System.out.println(zapis);
    }

    public static class ReportBuilder {

        private String naslov;
        private List<String> zapis;

        public ReportBuilder(String naslov) {
            this.naslov = naslov;
            
        }
        
        public Report build(){
            return new Report(this);
        }
        public void setZapis()
        {
            this.zapis.add(naslov);
        }
    }

}
