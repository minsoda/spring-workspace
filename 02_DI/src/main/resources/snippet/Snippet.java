package snippet;

public class Snippet {
	private void newInstanceHello(String name) {
			String className = properties.getProperty(name).trim();
			System.out.println("hello.properties에서 추출한 className : " + className);
		
			try {
				Class cls = Class.forName(className);
				Object obj = cls.newInstance();
				if(obj instanceof Hello) {
					this.hello = (Hello) obj;
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
}

