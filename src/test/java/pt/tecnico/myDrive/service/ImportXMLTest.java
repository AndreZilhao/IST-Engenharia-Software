package pt.tecnico.myDrive.service;

import org.junit.Test;
import pt.tecnico.myDrive.domain.*;

public class ImportXMLTest extends AbstractServiceTest {


	private MyDrive md;
	private static final String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
			+ "<myDrive>"
			+ "  <user username=\"jtb\">"
			+ "    <password>\"Fernandes\"</password>"
			+ "    <name>\"Joaquim Teófilo Braga\"</name>"
			+ "    <home>\"/home/jtb\"</home>"
			+ "    <mask>\"rwxd----\"</mask>"
			+ "  </user>"
			+ "  <user username=\"jms\">"
			+ "    <password>\"marquesSilva\"</password>"
			+ "    <name>\"João Marques Silva\"</name>"
			+ "    <home>\"/home/jms\"</home>"
			+ "    <mask>\"rwxd----\"</mask>"
			+ "  </user>"
			+ "  <user username=\"mja\">"
			+ "   <name>\"Manuel José de Arriaga\"</name>"
			+ "   <password>\"Peyrelongue\"</password>"
			+ "  </user>"
			+ "  <plain id=\"3\">"
			+ "    <path>\"/home/jtb/ui/iu/uiy\"</path>"
			+ "    <name>\"profile\"</name>"
			+ "    <owner>\"jtb\"</owner>"
			+ "    <perm>\"rw-dr---\"</perm>"
			+ "    <contents>\"Primeiro chefe de Estado do regime republicano (acumulando com a chefia do governo), numa capacidade provisória até à eleição do primeiro presidente da República.\"</contents>"
			+ "  </plain>"
			+ "  <dir id=\"4\">"
			+ "    <path>\"/home/jtb\"</path>"
			+ "    <name>\"documents\"</name>"
			+ "    <owner>\"jtb\"</owner>"
			+ "    <perm>\"rwxdr-x-\"</perm>"
			+ "  </dir>"
			+ "  <link id=\"5\">"
			+ "    <path>\"/home/jtb\"</path>"
			+ "    <name>\"doc\"</name>"
			+ "    <owner>\"jtb\"</owner>"
			+ "    <perm>\"r-xdr-x-\"</perm>"
			+ "    <value>\"/home/jtb/documents\"</value>"
			+ "  </link>"
			+ "  <dir id=\"7\">"
			+ "    <path>\"/home/jtb\"</path>"
			+ "    <owner>\"jtb\"</owner>"
			+ "    <name>\"bin\"</name>"
			+ "    <perm>\"rwxd--x-\"</perm>"
			+ "  </dir>"
			+ "  <dir id=\"666\">"
			+ "    <path>\"/home/1/2/3/4/5/6\"</path>"
			+ "    <owner>\"jtb\"</owner>"
			+ "    <name>\"uuid\"</name>"
			+ "    <perm>\"rwxd--x-\"</perm>"
			+ "  </dir>"
			+ "  <app id=\"9\">"
			+ "    <path>\"/home/jtb/bin\"</path>"
			+ "    <name>\"hello\"</name>"
			+ "    <owner>\"jtb\"</owner>"
			+ "    <perm>\"rwxd--x-\"</perm>"
			+ "    <method>\"pt.tecnico.myDrive.app.Hello\"</method>"
			+ "  </app>"
			+ "  <link id=\"51\">"
			+ "    <path>\"/a/b/c/d/e/f/g/h/i\"</path>"
			+ "    <name>\"docweq\"</name>"
			+ "    <owner>\"jtb\"</owner>"
			+ "    <perm>\"r-xdr-x-\"</perm>"
			+ "    <value>\"/home/jtb/documents\"</value>"
			+ "  </link>"
			+ "</myDrive>";


	protected void populate() {
		md = MyDriveService.getMyDrive();
	}

	@Test
	public void success() throws Exception {

	}

}
