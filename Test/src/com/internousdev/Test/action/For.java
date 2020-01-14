package com.internousdev.Test.action;

public class For {

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

}
