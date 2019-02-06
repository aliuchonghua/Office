package com.westos.Information.bean;

import java.util.Objects;

public class City {
   private String sheng;
   private String shi;
   private String xian;

   public String getSheng() {
      return sheng;
   }

   public void setSheng(String sheng) {
      this.sheng = sheng;
   }

   public String getShi() {
      return shi;
   }

   public void setShi(String shi) {
      this.shi = shi;
   }

   public String getXian() {
      return xian;
   }

   public void setXian(String xian) {
      this.xian = xian;
   }

   @Override
   public String toString() {
      return "City{" +
              "sheng='" + sheng + '\'' +
              ", shi='" + shi + '\'' +
              ", xian='" + xian + '\'' +
              '}';
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      City city = (City) o;
      return Objects.equals(sheng, city.sheng) &&
              Objects.equals(shi, city.shi) &&
              Objects.equals(xian, city.xian);
   }

   @Override
   public int hashCode() {
      return Objects.hash(sheng, shi, xian);
   }
}
