package com.brainmentors.testengine.question.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import com.brainmentors.testengine.questions.dto.QuestionDTO;
import com.brainmentors.testengine.utils.CommonDAO;
import com.brainmentors.testengine.utils.SQLConstants;

public class QuestionDAO {
	public boolean isUploaded(ArrayList<QuestionDTO> questions) throws ClassNotFoundException, SQLException {
		boolean isUpload = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
		if(questions!=null  && questions.size()>0) {
			con = CommonDAO.getConnection();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(SQLConstants.QUESTION_UPLOAD_SQL);
			for(QuestionDTO question : questions) {
				pstmt.setInt(1, question.getId());
				pstmt.setString(2, question.getName());
				int position = 3;
				for(String option : question.getOptions()) {
					pstmt.setString(position, option);
					position++;
				}
				pstmt.setString(7, question.getRightAnswer());
				pstmt.setInt(8, question.getScore());
				pstmt.addBatch();
				
			}
			int results[] = pstmt.executeBatch();
			boolean fail = false;
			for(int r : results) {
				if(r<1) {
					fail = true;
					break;
				}
			}
			if(fail) {
				con.rollback();
			}
			else {
				con.commit();
				return true;
			}
		}
		}
		finally {
			if(pstmt!=null) {
				pstmt.close();
			}
			if(con!=null) {
				con.close();
			}
		}
		return isUpload;
	}

}
