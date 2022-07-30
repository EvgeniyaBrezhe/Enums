package ua.hillel.enums.model;

public class Store {
    private String name;
    private String url;
    private User[] users;
    private User authorisedUser;

    public Store(String name, String url, User[] users) {
        this.name = name;
        this.url = url;
        this.users = users;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public User[] getUsers() {
        return users;
    }

    public void setUsers(User[] users) {
        this.users = users;
    }

    public User getAuthorisedUser() {
        return authorisedUser;
    }

    public void setAuthorisedUser(User authorisedUser) {
        this.authorisedUser = authorisedUser;
    }

    public boolean login(String name, String password) {
        for (int i = 0; i < users.length; i++) {
            if (users[i].getLogin().equals(name) && users[i].getPassword().equals(password)) {
                authorisedUser = users[i];
                return true;
            }
        }
        return false;
    }

    public void getCurrentUserRights(User authorisedUser) {
        switch (authorisedUser.getRole()) {
            case DIRECTOR:
                System.out.println("Director, can manager staff and prices");
                break;
            case ADMINISTRATOR:
                System.out.println("Administator, can add products and its descriptions");
                break;
            case MANAGER:
                System.out.println("Manager, can speak with clients");
                break;
            case CLIENT:
                System.out.println("Client, can buy products and use discounts");
                break;
            case ANONYMOUS:
                System.out.println("Anonymous, can buy products and/or log in");
                break;
        }
    }

    public void logout(User authorisedUser) {
        authorisedUser = null;
        System.out.println("User logged out");
    }
}
