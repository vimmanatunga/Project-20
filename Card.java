public class Card {
    private String name;
    private Category[] categories;

    public Card(String name, int speed, int weight, int era, int legs, int wings) {
        this.name = name;
        categories = new Category[5];

        categories[0] = new Category("Speed", speed);
        categories[1] = new Category("Weight", weight);
        categories[2] = new Category("Era", era);
        categories[3] = new Category("Legs", legs);
        categories[4] = new Category("Wings", wings);
    }

    public String getName() {
        return name;
    }

    public Category getCategory(String categoryName) {
        for (int i = 0; i < categories.length; i++) {
            if (categories[i].getName().equalsIgnoreCase(categoryName)) {
                return categories[i];
            }
        }
        return null;
    }

    public boolean isBetterThan(Card otherCard, String categoryName) {
        Category thisCategory = getCategory(categoryName);
        Category otherCategory = otherCard.getCategory(categoryName);

        if (thisCategory == null || otherCategory == null) {
            return false;
        }

        return thisCategory.getValue() > otherCategory.getValue();
    }
}