package dev.campbell.models;

public class TradeMarket {

    private int tradeId;

    private int creatorId; //ID of the person who created the trade request

    private int offerId; //ID of the person who offered a complete trade

    private String creatorName;

    private String offererName;

    private String requestedCard; //card of creator

    private String offerRequestedCard; //Card of offer person

    //Constructors


    public TradeMarket() {
    }

    public TradeMarket(int creatorId, int offerId) {
        this.creatorId = creatorId;
        this.offerId = offerId;
    }

    public TradeMarket(int creatorId, String requestedCard) {
        this.creatorId = creatorId;
        this.requestedCard = requestedCard;
    }



    public TradeMarket(int creatorId, int offerId, String requestedCard, String offerRequestedCard) {
        this.creatorId = creatorId;
        this.offerId = offerId;
        this.requestedCard = requestedCard;
        this.offerRequestedCard = offerRequestedCard;
    }

    public TradeMarket(int tradeId, int creatorId, int offerId, String requestedCard, String offerRequestedCard) {
        this.tradeId = tradeId;
        this.creatorId = creatorId;
        this.offerId = offerId;
        this.requestedCard = requestedCard;
        this.offerRequestedCard = offerRequestedCard;
    }

    public TradeMarket(int tradeId, int creatorId, String creatorName, String requestedCard, int offerId, String offererName, String offerRequestedCard) {
        this.tradeId = tradeId;
        this.creatorId = creatorId;
        this.creatorName = creatorName;
        this.requestedCard = requestedCard;
        this.offerId = offerId;
        this.offererName = offererName;
        this.offerRequestedCard = offerRequestedCard;
    }

    //Getters and setters


    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public String getOffererName() {
        return offererName;
    }

    public void setOffererName(String offererName) {
        this.offererName = offererName;
    }

    public int getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(int creatorId) {
        this.creatorId = creatorId;
    }

    public int getOfferId() {
        return offerId;
    }

    public void setOfferId(int offerId) {
        this.offerId = offerId;
    }

    public String getRequestedCard() {
        return requestedCard;
    }

    public void setRequestedCard(String requestedCard) {
        this.requestedCard = requestedCard;
    }

    public String getOfferRequestedCard() {
        return offerRequestedCard;
    }

    public void setOfferRequestedCard(String offerRequestedCard) {
        this.offerRequestedCard = offerRequestedCard;
    }

    public int getTradeId() {
        return tradeId;
    }

    public void setTradeId(int tradeId) {
        this.tradeId = tradeId;
    }

    @Override
    public String toString() {
        return "{tradeId=" + tradeId +
                ", creatorId=" + creatorId +
                ", creatorName='" + creatorName +
                ", requestedCard='" + requestedCard +
                ", offerId=" + offerId +
                ", offererName='" + offererName +
                ", offerRequestedCard='" + offerRequestedCard +
                '}';
    }
}