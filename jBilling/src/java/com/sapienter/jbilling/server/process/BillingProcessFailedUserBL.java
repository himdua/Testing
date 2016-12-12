/*
 * JBILLING CONFIDENTIAL
 * _____________________
 *
 * [2003] - [2012] Enterprise jBilling Software Ltd.
 * All Rights Reserved.
 *
 * NOTICE:  All information contained herein is, and remains
 * the property of Enterprise jBilling Software.
 * The intellectual and technical concepts contained
 * herein are proprietary to Enterprise jBilling Software
 * and are protected by trade secret or copyright law.
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden.
 */

package com.sapienter.jbilling.server.process;

import java.util.*;
import org.apache.log4j.Logger;


import com.sapienter.jbilling.common.FormatLogger;
import com.sapienter.jbilling.server.process.db.*;
import com.sapienter.jbilling.server.user.db.UserDAS;
import com.sapienter.jbilling.server.user.db.UserDTO;
import com.sapienter.jbilling.server.list.ResultList;

public class BillingProcessFailedUserBL  extends ResultList {
	private BillingProcessFailedUserDAS bpFailedUsersDas = null;
    private BatchProcessInfoDAS processInfoDas = null;
    private UserDAS userDas = null;
    private UserDTO user = null;
    private BatchProcessInfoDTO processInfo = null;
    private BillingProcessFailedUserDTO bPFailedUsers = null;
    
    public BillingProcessFailedUserBL(Integer processInfoId) {
        init();
        set(processInfoId);
    }
    
    public BillingProcessFailedUserBL() {
        init();
    }
    
    private void init() {
       userDas = new UserDAS();
       processInfoDas = new BatchProcessInfoDAS();
       bpFailedUsersDas = new BillingProcessFailedUserDAS();
    }

    public BillingProcessFailedUserDTO getEntity() {
        return bPFailedUsers;
    }
    
    public void set(Integer id) {
        bPFailedUsers = bpFailedUsersDas.find(id);
    }
    
    public void create(Integer batchProcessId, Integer userId) {
    	user = userDas.find(userId);
    	processInfo = processInfoDas.find(batchProcessId);
    	bpFailedUsersDas.create(processInfo, user);
    }
    
    public List<BillingProcessFailedUserDTO> findByBatchProcessId (Integer batchProcessId) {
    	List<BillingProcessFailedUserDTO> list = bpFailedUsersDas.getEntitiesByBatchProcessId(batchProcessId);
    	if(list !=null) {
    		return list;
    	}
    	return null;
    }
    
    public List<UserDTO> getUsersByExecutionId (Integer executionId) {
    	List<UserDTO> users = new ArrayList<UserDTO>();
    	for(BillingProcessFailedUserDTO dto : bpFailedUsersDas.getEntitiesByExecutionId(executionId)) {
    		users.add(dto.getUser());
    	}
    	return users;
    }
}