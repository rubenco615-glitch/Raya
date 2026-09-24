public enum Ficha {

    X, O;

    public Ficha siguiente() {
        if (this == X) {
            return O;
        } else {
            return X;
        }
    }
}
