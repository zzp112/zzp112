package edu.fjnu.hrmis.ui;
/**
 * @author zzp
 *
 */
import edu.fjnu.hrmis.utils.EmpMISUtils;
public class MainMenuUI implements BaseUI {
	/*
	 * 
	 * @see edu.fjnu.hrmis.ui.BaseUI#run()
	 */
	@Override
	public void run() {

		boolean isContinued = true;
		while (isContinued) {
			System.out.println("\n倓堊訧捅 - Employee Information - Main Menu");
			System.out
					.println("=====================================================\n");
			System.out.println("1 - Print All Current Records");
			System.out.println("2 每 Print All Current Records (formatted)");
			System.out.println("3 每 Print Names and Phone Numbers");
			System.out.println("4 每 Print Names and Phone Numbers (formatted)");
			System.out.println("5 - Search for specific Record(s)");
			System.out.println("6 - Add New Records");
			System.out.println("7 每 Delete Records\n");
			System.out.println("8 每 Alter Records\n");
			System.out.println("Q - Quit\n");
			System.out.print("Your Selection: | ");
			String entry = EmpMISUtils.getEntry();
			if (EmpMISUtils.isEmpty(entry)) {
				EmpMISUtils
						.pause("No selection entered. Press Enter to continue＃");
				continue;
			}
			switch (entry.toUpperCase().charAt(0)) {
			case '1':
				EmpMISUtils.runUIComponent(UIType.PRINT_EMP);
				break;
			case '2':
				EmpMISUtils.runUIComponent(UIType.LIST_SORTED_EMP);
				break;
			case '3':
				EmpMISUtils.runUIComponent(UIType.PRINT_NAME_PHONE);
				break;
			case '4':
				EmpMISUtils.runUIComponent(UIType.PRINT_NAME_PHONE_FORMAT);
				break;
			case '5':
				EmpMISUtils.runUIComponent(UIType.PRINT_SEARCH_RECORDS);
				break;
			case '6':
				EmpMISUtils.runUIComponent(UIType.ADD_EMP);
				break;
			case '7':
				EmpMISUtils.runUIComponent(UIType.DELETE_EMP_RECORDS);
				break;
			case '8':
				EmpMISUtils.runUIComponent(UIType.AlTER_EMP_RECORDS);
			case 'Q':
				isContinued = false;
				break;
			default:
				EmpMISUtils.pause("Invalid code! Press Enter to continue＃");
			}

		}

	}

}
