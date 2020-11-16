package pl.kl.petowner.model;

public enum Race {
    LABRADOR ("Labrador"),
    HUSKY ("Husky"),
    GOLDEN_RETRIEVER ("Golden Retriever"),
    CHIHUAHUA ("Chihuahua"),
    TERRIER ("Terrier"),
    POODLE ("Poodle");

    private final String commonName;

    Race(String commonName) {
        this.commonName = commonName;
    }

    public String getCommonName() {
        return commonName;
    }
}
