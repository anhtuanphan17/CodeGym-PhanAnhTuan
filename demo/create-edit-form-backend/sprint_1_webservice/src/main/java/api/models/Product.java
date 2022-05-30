package api.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "price", nullable = false)
    private Double price;
    @Column(name = "image", columnDefinition = "LONGTEXT")
    private String image;
    @Column(name = "qr_scan", columnDefinition = "LONGTEXT")
    private String qrScan;
    @Column(name = "screen_size", length = 50)
    private String screenSize;
    @Column(name = "camera", length = 50)
    private String camera;
    @Column(name = "selfie", length = 50)
    private String selfie;
    @Column(name = "cpu", length = 50)
    private String cpu;
    @Column(name = "memory", length = 50)
    private String memory;

    @Column(name = "other_description", columnDefinition = "LONGTEXT")
    private String otherDescription;

    @OneToMany(mappedBy = "product")
    private Set<Invoice> invoiceSet;

    @OneToMany(mappedBy = "product")
    private Set<Storage> storageSet;

    @Column(name = "delete_flag", nullable = false)
    private boolean deleteFlag;

    public Product() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getQrScan() {
        return qrScan;
    }

    public void setQrScan(String qrScan) {
        this.qrScan = qrScan;
    }

    public String getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(String screenSize) {
        this.screenSize = screenSize;
    }

    public String getCamera() {
        return camera;
    }

    public void setCamera(String camera) {
        this.camera = camera;
    }

    public String getSelfie() {
        return selfie;
    }

    public void setSelfie(String selfie) {
        this.selfie = selfie;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public String getOtherDescription() {
        return otherDescription;
    }

    public void setOtherDescription(String otherDescription) {
        this.otherDescription = otherDescription;
    }

    public Set<Invoice> getInvoiceSet() {
        return invoiceSet;
    }

    public void setInvoiceSet(Set<Invoice> invoiceSet) {
        this.invoiceSet = invoiceSet;
    }

    public Set<Storage> getStorageSet() {
        return storageSet;
    }

    public void setStorageSet(Set<Storage> storageSet) {
        this.storageSet = storageSet;
    }

    public boolean isDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
    }
}
