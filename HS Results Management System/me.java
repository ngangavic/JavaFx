                            while (setE3.next()) {
                            while (setComments.next()) {
                            while (setEngGrade.next()) {
                            while (setEngTeacher.next()) {
                                        //kis
                            while (setKisGrade.next()) {
                            while (setKisTeacher.next()) {
                                        //mat
                            while (setMatGrade.next()) {
                            while (setMatTeacher.next()) {
                                        //chem
                            while (setChemGrade.next()) {
                            while (setChemTeacher.next()) {
                                        //bio
                            while (setBioGrade.next()) {
                            while (setBioTeacher.next()) {
                                        //phy
                            while (setPhyGrade.next()) {
                            while (setPhyTeacher.next()) {
                                        //geo
                            while (setGeoGrade.next()) {
                            while (setGeoTeacher.next()) {
                                        //his
                            while (setHisGrade.next()) {
                            while (setHisTeacher.next()) {
                                        //cre
                            while (setCreGrade.next()) {
                            while (setCreTeacher.next()) {
                                        //bus
                            while (setBusGrade.next()) {
                            while (setBusTeacher.next()) {
                                        //agri
                            while (setAgriGrade.next()) {
                            while (setAgriTeacher.next()) {
                            while (setTotal.next()) {

                            PdfPTable table = new PdfPTable(7);
																																					
																																					
																																					
document.add(table);
}}}}}}}}}}}}}}}}}}}}}}}}}
																																				
																																				
																																				
																																				
				while (setF1T1E3.next()){																																
                while (setF1T2E3.next()){
                    while (setF1T3E3.next()){
                        while (setF2T1E3.next()) {
                            while (setF2T2E3.next()){
                                while (setF2T3E3.next()){
                                    while (setF3T1E3.next()){
                                        while (setF3T2E3.next()) {
                                            while (setF3T3E3.next()){
                                                while (setF4T1E3.next()){
                                                    while (setF4T2E3.next()){
                                                        while (setF4T3E3.next()) {
            Paragraph labelSummary = new Paragraph("PERFORMANCE TREND",new Font(Font.FontFamily.TIMES_ROMAN, 8,Font.BOLD));
			
			contentByte.addTemplate(template, 30, 275);
        }}}}}}}}}}}}
		
		PdfPCell f3t3m = new PdfPCell(new Paragraph(String.valueOf(Integer.parseInt(setF3T3E3.getString(41))/11)+" "+setF3T3E3.getString(43)+" "+setF3T3E3.getString(42),font));
		
		dataSet.setValue(Float.parseFloat(setF4T3E3.getString(43)), "Marks", "F4T3");
		
		String sqlF4T2Ex3 = "SELECT * FROM tbl_f4_t2_"+ex+" WHERE adm=?";
		String sqlF4T3Ex3 = "SELECT * FROM tbl_f4_t3_"+ex+" WHERE adm=?";
		
		PreparedStatement statementF4T2E3 = connection.prepareStatement(sqlF4T2Ex3);
		PreparedStatement statementF4T3E3 = connection.prepareStatement(sqlF4T3Ex3);
		
		statementF4T2E3.setString(1,adm);
		statementF4T3E3.setString(1,adm);
		
		ResultSet setF4T2E3 = statementF4T2E3.executeQuery();
		ResultSet setF4T3E3 = statementF4T3E3.executeQuery();