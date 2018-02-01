package com.tivo.ui.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "sources")
public class Source {
	
	@Id
	private String sourceId;														
    private String gmtOffsetId;
    private String longName;
    private String callLetters;
    private String observeDstYn;
    private String affiliateSourceId1;
    private String linkTargetYn;
    private String linkSourceYn;;
    private String affiliateSourceId2;
    private String affiliateSourceId3;
    private String multiFeedYn;
    private String sourceActiveDate;
    private String dstTypeId = "4";
    private String sourceInactiveDate;
    private String sapYn;
    private String fccChannel;
    private String digiFccChannel;
    private String hdtvYn;
    private String city;
    private String stateprovinceId;
    private String countryId;
    private String dmaCode;
    private String assignedSchedulingTeamId;
    private String assignedEditorialTeamId;
    private String assignedWriterId;
    private String assignedLoggerId;
    private String assignedEditorId;
    private String externallyScheduledYn;
    private String aliasParentSource;
    private String affiliateSourceYn;
    private String internationalSourceYn;
    private String tvDataCodeString;
    private String intraSourceFeedYn;
    private String progLogWarnYn;
    private String useParentLogYn;
    private String trueSourceName;
    private String tmsStationId;
    private String virtualChannelLocation;
    private String ownedOperatedYn;;
    private String networkYn;;
    private String admtYn;;
    private String admt_text;
    private String pcipvctActiveYn;;
    private String digitalYn;;
    private String hdtvSimulcastYn;;
    private String lptvYn;;
    private String cableAffiliationId;
    private String deliverYn;;
    private String officialCallSign;
    private String readOnlyScheduleYn;;
    private String fullChildScheduleYn;
    private String isInternalSource;
    private String isLocalOrigin;
    private String parentSourceId;
    private String analogSourceId;
    private String ipgSourceId;
    private String approvedDate = "49:42.5";
    private String dstOffset;
    private String dstAdjust;
    private String loChannel;
    private String stetSource;
    private String creationUser;
    private String creationDate;
    private String lastUpdateUser;
    private String lastUpdateDate;
    private String isActive;
    private String assignedUserId;
    private String in_magazine;
    private String isScheduleAudit;
    private String isAuditLogging;
    private String sourceTvgEmail;
    private String isWorkQueueOnIngest;
    private String isHdtv;
    private String isExtractOnDemand;
    private String useSourceLevelCopy;
    private String sourceRegionId;
    private String gdbsChannelCode;
    private String isVod;
    private String is3d;
    private String feedLocationId;
    private String name;
    private String gmtOffset;
    private String description;
    private String isDefault;
    
    
	public String getSourceId() {
		return sourceId;
	}
	public void setSourceId(String sourceId) {
		this.sourceId = sourceId;
	}
	public String getGmtOffsetId() {
		return gmtOffsetId;
	}
	public void setGmtOffsetId(String gmtOffsetId) {
		this.gmtOffsetId = gmtOffsetId;
	}
	public String getLongName() {
		return longName;
	}
	public void setLongName(String longName) {
		this.longName = longName;
	}
	public String getCallLetters() {
		return callLetters;
	}
	public void setCallLetters(String callLetters) {
		this.callLetters = callLetters;
	}
	public String getObserveDstYn() {
		return observeDstYn;
	}
	public void setObserveDstYn(String observeDstYn) {
		this.observeDstYn = observeDstYn;
	}
	public String getAffiliateSourceId1() {
		return affiliateSourceId1;
	}
	public void setAffiliateSourceId1(String affiliateSourceId1) {
		this.affiliateSourceId1 = affiliateSourceId1;
	}
	public String getLinkTargetYn() {
		return linkTargetYn;
	}
	public void setLinkTargetYn(String linkTargetYn) {
		this.linkTargetYn = linkTargetYn;
	}
	public String getLinkSourceYn() {
		return linkSourceYn;
	}
	public void setLinkSourceYn(String linkSourceYn) {
		this.linkSourceYn = linkSourceYn;
	}
	public String getAffiliateSourceId2() {
		return affiliateSourceId2;
	}
	public void setAffiliateSourceId2(String affiliateSourceId2) {
		this.affiliateSourceId2 = affiliateSourceId2;
	}
	public String getAffiliateSourceId3() {
		return affiliateSourceId3;
	}
	public void setAffiliateSourceId3(String affiliateSourceId3) {
		this.affiliateSourceId3 = affiliateSourceId3;
	}
	public String getMultiFeedYn() {
		return multiFeedYn;
	}
	public void setMultiFeedYn(String multiFeedYn) {
		this.multiFeedYn = multiFeedYn;
	}
	public String getSourceActiveDate() {
		return sourceActiveDate;
	}
	public void setSourceActiveDate(String sourceActiveDate) {
		this.sourceActiveDate = sourceActiveDate;
	}
	
	public String getDstTypeId() {
		return dstTypeId;
	}
	public void setDstTypeId(String dstTypeId) {
		this.dstTypeId = dstTypeId;
	}
	public String getSourceInactiveDate() {
		return sourceInactiveDate;
	}
	public void setSourceInactiveDate(String sourceInactiveDate) {
		this.sourceInactiveDate = sourceInactiveDate;
	}
	public String getSapYn() {
		return sapYn;
	}
	public void setSapYn(String sapYn) {
		this.sapYn = sapYn;
	}
	public String getFccChannel() {
		return fccChannel;
	}
	public void setFccChannel(String fccChannel) {
		this.fccChannel = fccChannel;
	}
	public String getDigiFccChannel() {
		return digiFccChannel;
	}
	public void setDigiFccChannel(String digiFccChannel) {
		this.digiFccChannel = digiFccChannel;
	}
	public String getHdtvYn() {
		return hdtvYn;
	}
	public void setHdtvYn(String hdtvYn) {
		this.hdtvYn = hdtvYn;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStateprovinceId() {
		return stateprovinceId;
	}
	public void setStateprovinceId(String stateprovinceId) {
		this.stateprovinceId = stateprovinceId;
	}
	public String getCountryId() {
		return countryId;
	}
	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}
	public String getDmaCode() {
		return dmaCode;
	}
	public void setDmaCode(String dmaCode) {
		this.dmaCode = dmaCode;
	}
	public String getAssignedSchedulingTeamId() {
		return assignedSchedulingTeamId;
	}
	public void setAssignedSchedulingTeamId(String assignedSchedulingTeamId) {
		this.assignedSchedulingTeamId = assignedSchedulingTeamId;
	}
	public String getAssignedEditorialTeamId() {
		return assignedEditorialTeamId;
	}
	public void setAssignedEditorialTeamId(String assignedEditorialTeamId) {
		this.assignedEditorialTeamId = assignedEditorialTeamId;
	}
	public String getAssignedWriterId() {
		return assignedWriterId;
	}
	public void setAssignedWriterId(String assignedWriterId) {
		this.assignedWriterId = assignedWriterId;
	}
	public String getAssignedLoggerId() {
		return assignedLoggerId;
	}
	public void setAssignedLoggerId(String assignedLoggerId) {
		this.assignedLoggerId = assignedLoggerId;
	}
	public String getAssignedEditorId() {
		return assignedEditorId;
	}
	public void setAssignedEditorId(String assignedEditorId) {
		this.assignedEditorId = assignedEditorId;
	}
	public String getExternallyScheduledYn() {
		return externallyScheduledYn;
	}
	public void setExternallyScheduledYn(String externallyScheduledYn) {
		this.externallyScheduledYn = externallyScheduledYn;
	}
	public String getAliasParentSource() {
		return aliasParentSource;
	}
	public void setAliasParentSource(String aliasParentSource) {
		this.aliasParentSource = aliasParentSource;
	}
	public String getAffiliateSourceYn() {
		return affiliateSourceYn;
	}
	public void setAffiliateSourceYn(String affiliateSourceYn) {
		this.affiliateSourceYn = affiliateSourceYn;
	}
	public String getInternationalSourceYn() {
		return internationalSourceYn;
	}
	public void setInternationalSourceYn(String internationalSourceYn) {
		this.internationalSourceYn = internationalSourceYn;
	}
	public String getTvDataCodeString() {
		return tvDataCodeString;
	}
	public void setTvDataCodeString(String tvDataCodeString) {
		this.tvDataCodeString = tvDataCodeString;
	}
	public String getIntraSourceFeedYn() {
		return intraSourceFeedYn;
	}
	public void setIntraSourceFeedYn(String intraSourceFeedYn) {
		this.intraSourceFeedYn = intraSourceFeedYn;
	}
	public String getProgLogWarnYn() {
		return progLogWarnYn;
	}
	public void setProgLogWarnYn(String progLogWarnYn) {
		this.progLogWarnYn = progLogWarnYn;
	}
	public String getUseParentLogYn() {
		return useParentLogYn;
	}
	public void setUseParentLogYn(String useParentLogYn) {
		this.useParentLogYn = useParentLogYn;
	}
	public String getTrueSourceName() {
		return trueSourceName;
	}
	public void setTrueSourceName(String trueSourceName) {
		this.trueSourceName = trueSourceName;
	}
	public String getTmsStationId() {
		return tmsStationId;
	}
	public void setTmsStationId(String tmsStationId) {
		this.tmsStationId = tmsStationId;
	}
	public String getVirtualChannelLocation() {
		return virtualChannelLocation;
	}
	public void setVirtualChannelLocation(String virtualChannelLocation) {
		this.virtualChannelLocation = virtualChannelLocation;
	}
	public String getOwnedOperatedYn() {
		return ownedOperatedYn;
	}
	public void setOwnedOperatedYn(String ownedOperatedYn) {
		this.ownedOperatedYn = ownedOperatedYn;
	}
	public String getNetworkYn() {
		return networkYn;
	}
	public void setNetworkYn(String networkYn) {
		this.networkYn = networkYn;
	}
	public String getAdmtYn() {
		return admtYn;
	}
	public void setAdmtYn(String admtYn) {
		this.admtYn = admtYn;
	}
	public String getAdmt_text() {
		return admt_text;
	}
	public void setAdmt_text(String admt_text) {
		this.admt_text = admt_text;
	}
	public String getPcipvctActiveYn() {
		return pcipvctActiveYn;
	}
	public void setPcipvctActiveYn(String pcipvctActiveYn) {
		this.pcipvctActiveYn = pcipvctActiveYn;
	}
	public String getDigitalYn() {
		return digitalYn;
	}
	public void setDigitalYn(String digitalYn) {
		this.digitalYn = digitalYn;
	}
	public String getHdtvSimulcastYn() {
		return hdtvSimulcastYn;
	}
	public void setHdtvSimulcastYn(String hdtvSimulcastYn) {
		this.hdtvSimulcastYn = hdtvSimulcastYn;
	}
	public String getLptvYn() {
		return lptvYn;
	}
	public void setLptvYn(String lptvYn) {
		this.lptvYn = lptvYn;
	}
	public String getCableAffiliationId() {
		return cableAffiliationId;
	}
	public void setCableAffiliationId(String cableAffiliationId) {
		this.cableAffiliationId = cableAffiliationId;
	}
	public String getDeliverYn() {
		return deliverYn;
	}
	public void setDeliverYn(String deliverYn) {
		this.deliverYn = deliverYn;
	}
	public String getOfficialCallSign() {
		return officialCallSign;
	}
	public void setOfficialCallSign(String officialCallSign) {
		this.officialCallSign = officialCallSign;
	}
	public String getReadOnlyScheduleYn() {
		return readOnlyScheduleYn;
	}
	public void setReadOnlyScheduleYn(String readOnlyScheduleYn) {
		this.readOnlyScheduleYn = readOnlyScheduleYn;
	}
	
	public String getFullChildScheduleYn() {
		return fullChildScheduleYn;
	}
	public void setFullChildScheduleYn(String fullChildScheduleYn) {
		this.fullChildScheduleYn = fullChildScheduleYn;
	}
	public String getIsInternalSource() {
		return isInternalSource;
	}
	public void setIsInternalSource(String isInternalSource) {
		this.isInternalSource = isInternalSource;
	}
	public String getIsLocalOrigin() {
		return isLocalOrigin;
	}
	public void setIsLocalOrigin(String isLocalOrigin) {
		this.isLocalOrigin = isLocalOrigin;
	}
	public String getParentSourceId() {
		return parentSourceId;
	}
	public void setParentSourceId(String parentSourceId) {
		this.parentSourceId = parentSourceId;
	}
	public String getAnalogSourceId() {
		return analogSourceId;
	}
	public void setAnalogSourceId(String analogSourceId) {
		this.analogSourceId = analogSourceId;
	}
	public String getIpgSourceId() {
		return ipgSourceId;
	}
	public void setIpgSourceId(String ipgSourceId) {
		this.ipgSourceId = ipgSourceId;
	}
	public String getApprovedDate() {
		return approvedDate;
	}
	public void setApprovedDate(String approvedDate) {
		this.approvedDate = approvedDate;
	}
	public String getDstOffset() {
		return dstOffset;
	}
	public void setDstOffset(String dstOffset) {
		this.dstOffset = dstOffset;
	}
	public String getDstAdjust() {
		return dstAdjust;
	}
	public void setDstAdjust(String dstAdjust) {
		this.dstAdjust = dstAdjust;
	}
	public String getLoChannel() {
		return loChannel;
	}
	public void setLoChannel(String loChannel) {
		this.loChannel = loChannel;
	}
	public String getStetSource() {
		return stetSource;
	}
	public void setStetSource(String stetSource) {
		this.stetSource = stetSource;
	}
	public String getCreationUser() {
		return creationUser;
	}
	public void setCreationUser(String creationUser) {
		this.creationUser = creationUser;
	}
	public String getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}
	public String getLastUpdateUser() {
		return lastUpdateUser;
	}
	public void setLastUpdateUser(String lastUpdateUser) {
		this.lastUpdateUser = lastUpdateUser;
	}
	public String getLastUpdateDate() {
		return lastUpdateDate;
	}
	public void setLastUpdateDate(String lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}
	public String getIsActive() {
		return isActive;
	}
	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	public String getAssignedUserId() {
		return assignedUserId;
	}
	public void setAssignedUserId(String assignedUserId) {
		this.assignedUserId = assignedUserId;
	}
	public String getIn_magazine() {
		return in_magazine;
	}
	public void setIn_magazine(String in_magazine) {
		this.in_magazine = in_magazine;
	}
	public String getIsScheduleAudit() {
		return isScheduleAudit;
	}
	public void setIsScheduleAudit(String isScheduleAudit) {
		this.isScheduleAudit = isScheduleAudit;
	}
	public String getIsAuditLogging() {
		return isAuditLogging;
	}
	public void setIsAuditLogging(String isAuditLogging) {
		this.isAuditLogging = isAuditLogging;
	}
	public String getSourceTvgEmail() {
		return sourceTvgEmail;
	}
	public void setSourceTvgEmail(String sourceTvgEmail) {
		this.sourceTvgEmail = sourceTvgEmail;
	}
	public String getIsWorkQueueOnIngest() {
		return isWorkQueueOnIngest;
	}
	public void setIsWorkQueueOnIngest(String isWorkQueueOnIngest) {
		this.isWorkQueueOnIngest = isWorkQueueOnIngest;
	}
	public String getIsHdtv() {
		return isHdtv;
	}
	public void setIsHdtv(String isHdtv) {
		this.isHdtv = isHdtv;
	}
	public String getIsExtractOnDemand() {
		return isExtractOnDemand;
	}
	public void setIsExtractOnDemand(String isExtractOnDemand) {
		this.isExtractOnDemand = isExtractOnDemand;
	}
	public String getUseSourceLevelCopy() {
		return useSourceLevelCopy;
	}
	public void setUseSourceLevelCopy(String useSourceLevelCopy) {
		this.useSourceLevelCopy = useSourceLevelCopy;
	}
	public String getSourceRegionId() {
		return sourceRegionId;
	}
	public void setSourceRegionId(String sourceRegionId) {
		this.sourceRegionId = sourceRegionId;
	}
	public String getGdbsChannelCode() {
		return gdbsChannelCode;
	}
	public void setGdbsChannelCode(String gdbsChannelCode) {
		this.gdbsChannelCode = gdbsChannelCode;
	}
	public String getIsVod() {
		return isVod;
	}
	public void setIsVod(String isVod) {
		this.isVod = isVod;
	}
	public String getIs3d() {
		return is3d;
	}
	public void setIs3d(String is3d) {
		this.is3d = is3d;
	}
	public String getFeedLocationId() {
		return feedLocationId;
	}
	public void setFeedLocationId(String feedLocationId) {
		this.feedLocationId = feedLocationId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGmtOffset() {
		return gmtOffset;
	}
	public void setGmtOffset(String gmtOffset) {
		this.gmtOffset = gmtOffset;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getIsDefault() {
		return isDefault;
	}
	public void setIsDefault(String isDefault) {
		this.isDefault = isDefault;
	}
	@Override
	public String toString() {
		return "Source [sourceId=" + sourceId + ", gmtOffsetId=" + gmtOffsetId + ", longName=" + longName
				+ ", callLetters=" + callLetters + ", observeDstYn=" + observeDstYn + ", affiliateSourceId1="
				+ affiliateSourceId1 + ", linkTargetYn=" + linkTargetYn + ", linkSourceYn=" + linkSourceYn
				+ ", affiliateSourceId2=" + affiliateSourceId2 + ", affiliateSourceId3=" + affiliateSourceId3
				+ ", multiFeedYn=" + multiFeedYn + ", sourceActiveDate=" + sourceActiveDate + ", dstTypeId=" + dstTypeId
				+ ", sourceInactiveDate=" + sourceInactiveDate + ", sapYn=" + sapYn + ", fccChannel=" + fccChannel
				+ ", digiFccChannel=" + digiFccChannel + ", hdtvYn=" + hdtvYn + ", city=" + city + ", stateprovinceId="
				+ stateprovinceId + ", countryId=" + countryId + ", dmaCode=" + dmaCode + ", assignedSchedulingTeamId="
				+ assignedSchedulingTeamId + ", assignedEditorialTeamId=" + assignedEditorialTeamId
				+ ", assignedWriterId=" + assignedWriterId + ", assignedLoggerId=" + assignedLoggerId
				+ ", assignedEditorId=" + assignedEditorId + ", externallyScheduledYn=" + externallyScheduledYn
				+ ", aliasParentSource=" + aliasParentSource + ", affiliateSourceYn=" + affiliateSourceYn
				+ ", internationalSourceYn=" + internationalSourceYn + ", tvDataCodeString=" + tvDataCodeString
				+ ", intraSourceFeedYn=" + intraSourceFeedYn + ", progLogWarnYn=" + progLogWarnYn + ", useParentLogYn="
				+ useParentLogYn + ", trueSourceName=" + trueSourceName + ", tmsStationId=" + tmsStationId
				+ ", virtualChannelLocation=" + virtualChannelLocation + ", ownedOperatedYn=" + ownedOperatedYn
				+ ", networkYn=" + networkYn + ", admtYn=" + admtYn + ", admt_text=" + admt_text + ", pcipvctActiveYn="
				+ pcipvctActiveYn + ", digitalYn=" + digitalYn + ", hdtvSimulcastYn=" + hdtvSimulcastYn + ", lptvYn="
				+ lptvYn + ", cableAffiliationId=" + cableAffiliationId + ", deliverYn=" + deliverYn
				+ ", officialCallSign=" + officialCallSign + ", readOnlyScheduleYn=" + readOnlyScheduleYn
				+ ", fullChildScheduleYn=" + fullChildScheduleYn + ", isInternalSource=" + isInternalSource
				+ ", isLocalOrigin=" + isLocalOrigin + ", parentSourceId=" + parentSourceId + ", analogSourceId="
				+ analogSourceId + ", ipgSourceId=" + ipgSourceId + ", approvedDate=" + approvedDate + ", dstOffset="
				+ dstOffset + ", dstAdjust=" + dstAdjust + ", loChannel=" + loChannel + ", stetSource=" + stetSource
				+ ", creationUser=" + creationUser + ", creationDate=" + creationDate + ", lastUpdateUser="
				+ lastUpdateUser + ", lastUpdateDate=" + lastUpdateDate + ", isActive=" + isActive + ", assignedUserId="
				+ assignedUserId + ", in_magazine=" + in_magazine + ", isScheduleAudit=" + isScheduleAudit
				+ ", isAuditLogging=" + isAuditLogging + ", sourceTvgEmail=" + sourceTvgEmail + ", isWorkQueueOnIngest="
				+ isWorkQueueOnIngest + ", isHdtv=" + isHdtv + ", isExtractOnDemand=" + isExtractOnDemand
				+ ", useSourceLevelCopy=" + useSourceLevelCopy + ", sourceRegionId=" + sourceRegionId
				+ ", gdbsChannelCode=" + gdbsChannelCode + ", isVod=" + isVod + ", is3d=" + is3d + ", feedLocationId="
				+ feedLocationId + ", name=" + name + ", gmtOffset=" + gmtOffset + ", description=" + description
				+ ", isDefault=" + isDefault + "]";
	}
	
	
	
	

}
