package com.internousdev.Test.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.Test.dao.LoginFunctionCartInfoDAO;
import com.internousdev.Test.dto.CartInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware {
	private Map<String, Object> session;
	private String userId;
	private String password;
	private int loginFlg;
	private String res;

	private CartInfoDTO cartInfoDTO = new CartInfoDTO();
	private List<CartInfoDTO> cartInfoDTOList = new ArrayList<CartInfoDTO>();
	private List<CartInfoDTO> temporaryUserCartInfoDTOList = new ArrayList<CartInfoDTO>();
	private List<CartInfoDTO> userCartInfoDTOList = new ArrayList<CartInfoDTO>();
	private LoginFunctionCartInfoDAO loginFunctionCartInfoDAO = new LoginFunctionCartInfoDAO();

	public String execute() {
		res = ERROR;
		int updateCountC = 0;
		int updateCountD = 0;
		int deleteCount = 0;
		String temporaryUserId = session.get("temporaryUserId").toString();
		int temporaryUserProductCount = Integer.parseInt(session.get("temporaryUserId").toString());


		cartInfoDTOList = loginFunctionCartInfoDAO.getCartInfoLinkTemporaryUser(temporaryUserId);						//【A】
		if(cartInfoDTOList == null) {
			decideBranch();

		} else {
			temporaryUserCartInfoDTOList = loginFunctionCartInfoDAO.getCartInfoLinkTemporaryUser(temporaryUserId);		//【A】仮ユーザーIDのカートリスト
			userCartInfoDTOList = loginFunctionCartInfoDAO.getCartInfoLinkUser(userId);									//【B】ユーザーIDのカートリスト

			for(int i = 0; i <= temporaryUserCartInfoDTOList.size(); i++) {
				int dbUserProductId = temporaryUserCartInfoDTOList.get(i).getProductId();

					for(int k = 0; k <= userCartInfoDTOList.size(); k++) {
						int dbtemporaryUserProductId = userCartInfoDTOList.get(k).getProductId();

							if(dbUserProductId != dbtemporaryUserProductId) {
								updateCountC = loginFunctionCartInfoDAO.updateUserId
										(session.get("temporaryUserId").toString(), userId);							//【C】

							} else {
								updateCountD = loginFunctionCartInfoDAO.updateCount
										(temporaryUserProductCount, userId);											//【D】

								deleteCount = loginFunctionCartInfoDAO.deleteTemporaryUserInfo(temporaryUserId);		//【E】


									if(updateCountC > 0  || deleteCount > 0) {
										decideBranch();

									} else {
										res = ERROR;
									}
							}
					}
			}

			return res;
		}





	}


	public Map<String, Object> getSession() {
		return this.session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	//ユーザーIDとログインフラグをsessionにつめて
			//カートフラグの有無によって次の分岐を決定するメソッド
			//同じ分岐を２回するのでメソッドにしました
			    public String decideBranch() {

				session.put("userId", userId);
				session.put("loginFlg", loginFlg);

				if(session.get("cartFlg") == null) {
					res = "homefunction";																					//resの変数strutsでの記載に合わせる

				} else {
					cartInfoDTOList = loginFunctionCartInfoDAO.getCartInfoDTO(userId);										//【F】
					res = "cartFunction";																					//resの変数strutsでの記載に合わせる

				}
				return res;
			    }








}
