package c.s.sample.apply.service;

import c.s.sample.apply.entity.ApplicationEntity;
import c.s.sample.apply.vo.ApplicationBlank;

/**
 * @author chineshine
 * @since  2020年5月21日
 */
public interface ApplicationService {
	
	public ApplicationEntity saveData(ApplicationBlank blank);
	
	public void doApply(ApplicationBlank applicationBlank);

}
