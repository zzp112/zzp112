/**
 * 
 */
package edu.fjnu.hrmis.ui;
/**
 * @author zzp
 *
 */
import edu.fjnu.hrmis.exception.EmpMISException;
/**
 * @author Administrator UI���ɹ���
 */
public class UIFactory {

	private static final UIFactory FACTORY = new UIFactory();

	public static UIFactory getInstance() {
		return FACTORY;
	}

	private UIFactory() {

	}

	/**
	 * ���UI����
	 * 
	 * @param uiType
	 *            ��������
	 * @return
	 */
	public BaseUI getComponent(String uiType) {

		BaseUI ui = null;

		if (uiType.equals(UIType.MAIN_MENU)) {
			ui = new MainMenuUI();
		} else if (uiType.equals(UIType.PRINT_EMP)) {
			ui = new EmpUI();
		} else if (uiType.equals(UIType.PRINT_NAME_PHONE)) {
			ui = new ShortEmpUI();
		} else if (uiType.equals(UIType.PRINT_NAME_PHONE_FORMAT)) {
			ui = new ShortEmpFormatUI();
		} else if (uiType.equals(UIType.PRINT_SEARCH_RECORDS)) {
			ui = new SearchUI();
		} else if (uiType.equals(UIType.ADD_EMP)) {
			ui = new AddEmpUI();
		} else if(uiType.equals(UIType.DELETE_EMP_RECORDS)){
			ui=new DeleteEmpUI();
		}
		else if (uiType.equals(UIType.LIST_SORTED_EMP)) {
			ui = new ListsSortedEmpsUI();
		}
		else if(uiType.equals(UIType.AlTER_EMP_RECORDS)){
			ui=new AlterEmpUI();
		}

		if (ui == null)
			throw new EmpMISException("UI����û�в����ڣ��������� :" + uiType);

		return ui;

	}

}
