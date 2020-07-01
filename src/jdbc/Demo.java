package jdbc;

public class Demo {
	public static void main(String[] args) {
		Feature ft = new Feature();
		ft.Show();
		System.out.println("Insert!!!");
		ft.Insert();
		ft.Show();
		System.out.println("Update!!!");
		ft.Update();
		ft.Show();
		System.out.println("Delete!!!");
		ft.Delete();
		ft.Show();
	}
}
