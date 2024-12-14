package com.nyc.sbpharmacy.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "message")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "messageid", nullable = false)
    private Long messageid;

    public Long getId() {
        return messageid;
    }

    public void setId(Long id) {
        this.messageid = id;
    }

    @OneToOne
    private AppUser sender;

    @OneToOne
    private AppUser receiver;

    private String messagebody;

    private LocalDateTime senddate;

    public Long getMessageid() {
        return messageid;
    }

    public void setMessageid(Long messageid) {
        this.messageid = messageid;
    }

    public AppUser getSender() {
        return sender;
    }

    public void setSender(AppUser sender) {
        this.sender = sender;
    }

    public AppUser getReceiver() {
        return receiver;
    }

    public void setReceiver(AppUser receiver) {
        this.receiver = receiver;
    }

    public String getMessagebody() {
        return messagebody;
    }

    public void setMessagebody(String messagebody) {
        this.messagebody = messagebody;
    }

    public LocalDateTime getSenddate() {
        return senddate;
    }

    public void setSenddate(LocalDateTime senddate) {
        this.senddate = senddate;
    }
}