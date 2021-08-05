class Q01Classe {
   public static String ISO88591toUTF8(String strISO) throws Exception {
      byte[] isoBytes = strISO.getBytes("ISO-8859-1");
      return new String(isoBytes, "UTF-8");
   }

   public static void main (String args[]) throws Exception {
      for(String linha = MyIO.readString(); linha.replace(" ","").equals("FIM") == false; linha = MyIO.readString()){
         Presidente x = new Presidente();
         x.ler(ISO88591toUTF8(linha));
         x.imprimir();
      }
   }
}
