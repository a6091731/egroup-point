package com.epoint.webapp.dao;

import java.util.List;

import com.epoint.webapp.entity.PayItem;

public interface PayItemDAO {
	public List<PayItem> getAllPayItemBySubClassID(int classID);
}
