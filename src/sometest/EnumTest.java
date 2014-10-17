package sometest;

public class EnumTest {
	public static void main(String[] args) {
		System.err.println(Product.Apple.getPrice());
	}
}

enum Product {
	Apple("apple", 10) {
		void ss() {
			// TODO Auto-generated method stub

		}
	},
	Orange("orange", 2) {
		@Override
		void ss() {
			// TODO Auto-generated method stub

		}
	};
	private String name;
	private int price;

	Product(String name, int price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	abstract void ss();

}