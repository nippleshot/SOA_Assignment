
package com.studentservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.studentservice package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _AddStudentInfo_QNAME = new QName("http://studentservice.com/", "addStudentInfo");
    private final static QName _AddStudentInfoResponse_QNAME = new QName("http://studentservice.com/", "addStudentInfoResponse");
    private final static QName _ChangeStudentInfo_QNAME = new QName("http://studentservice.com/", "changeStudentInfo");
    private final static QName _ChangeStudentInfoResponse_QNAME = new QName("http://studentservice.com/", "changeStudentInfoResponse");
    private final static QName _DeleteStudentInfo_QNAME = new QName("http://studentservice.com/", "deleteStudentInfo");
    private final static QName _DeleteStudentInfoResponse_QNAME = new QName("http://studentservice.com/", "deleteStudentInfoResponse");
    private final static QName _GetStudentInfo_QNAME = new QName("http://studentservice.com/", "getStudentInfo");
    private final static QName _GetStudentInfoResponse_QNAME = new QName("http://studentservice.com/", "getStudentInfoResponse");
    private final static QName _IdentifyByIdCard_QNAME = new QName("http://studentservice.com/", "identifyByIdCard");
    private final static QName _IdentifyByIdCardResponse_QNAME = new QName("http://studentservice.com/", "identifyByIdCardResponse");
    private final static QName _IdentifyByStudentId_QNAME = new QName("http://studentservice.com/", "identifyByStudentId");
    private final static QName _IdentifyByStudentIdResponse_QNAME = new QName("http://studentservice.com/", "identifyByStudentIdResponse");
    private final static QName _IdentifyDepartment_QNAME = new QName("http://studentservice.com/", "identifyDepartment");
    private final static QName _IdentifyDepartmentResponse_QNAME = new QName("http://studentservice.com/", "identifyDepartmentResponse");
    private final static QName _IdentifyDormitory_QNAME = new QName("http://studentservice.com/", "identifyDormitory");
    private final static QName _IdentifyDormitoryResponse_QNAME = new QName("http://studentservice.com/", "identifyDormitoryResponse");
    private final static QName _IdentifyStudentStatus_QNAME = new QName("http://studentservice.com/", "identifyStudentStatus");
    private final static QName _IdentifyStudentStatusResponse_QNAME = new QName("http://studentservice.com/", "identifyStudentStatusResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.studentservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AddStudentInfo }
     * 
     */
    public AddStudentInfo createAddStudentInfo() {
        return new AddStudentInfo();
    }

    /**
     * Create an instance of {@link AddStudentInfoResponse }
     * 
     */
    public AddStudentInfoResponse createAddStudentInfoResponse() {
        return new AddStudentInfoResponse();
    }

    /**
     * Create an instance of {@link ChangeStudentInfo }
     * 
     */
    public ChangeStudentInfo createChangeStudentInfo() {
        return new ChangeStudentInfo();
    }

    /**
     * Create an instance of {@link ChangeStudentInfoResponse }
     * 
     */
    public ChangeStudentInfoResponse createChangeStudentInfoResponse() {
        return new ChangeStudentInfoResponse();
    }

    /**
     * Create an instance of {@link DeleteStudentInfo }
     * 
     */
    public DeleteStudentInfo createDeleteStudentInfo() {
        return new DeleteStudentInfo();
    }

    /**
     * Create an instance of {@link DeleteStudentInfoResponse }
     * 
     */
    public DeleteStudentInfoResponse createDeleteStudentInfoResponse() {
        return new DeleteStudentInfoResponse();
    }

    /**
     * Create an instance of {@link GetStudentInfo }
     * 
     */
    public GetStudentInfo createGetStudentInfo() {
        return new GetStudentInfo();
    }

    /**
     * Create an instance of {@link GetStudentInfoResponse }
     * 
     */
    public GetStudentInfoResponse createGetStudentInfoResponse() {
        return new GetStudentInfoResponse();
    }

    /**
     * Create an instance of {@link IdentifyByIdCard }
     * 
     */
    public IdentifyByIdCard createIdentifyByIdCard() {
        return new IdentifyByIdCard();
    }

    /**
     * Create an instance of {@link IdentifyByIdCardResponse }
     * 
     */
    public IdentifyByIdCardResponse createIdentifyByIdCardResponse() {
        return new IdentifyByIdCardResponse();
    }

    /**
     * Create an instance of {@link IdentifyByStudentId }
     * 
     */
    public IdentifyByStudentId createIdentifyByStudentId() {
        return new IdentifyByStudentId();
    }

    /**
     * Create an instance of {@link IdentifyByStudentIdResponse }
     * 
     */
    public IdentifyByStudentIdResponse createIdentifyByStudentIdResponse() {
        return new IdentifyByStudentIdResponse();
    }

    /**
     * Create an instance of {@link IdentifyDepartment }
     * 
     */
    public IdentifyDepartment createIdentifyDepartment() {
        return new IdentifyDepartment();
    }

    /**
     * Create an instance of {@link IdentifyDepartmentResponse }
     * 
     */
    public IdentifyDepartmentResponse createIdentifyDepartmentResponse() {
        return new IdentifyDepartmentResponse();
    }

    /**
     * Create an instance of {@link IdentifyDormitory }
     * 
     */
    public IdentifyDormitory createIdentifyDormitory() {
        return new IdentifyDormitory();
    }

    /**
     * Create an instance of {@link IdentifyDormitoryResponse }
     * 
     */
    public IdentifyDormitoryResponse createIdentifyDormitoryResponse() {
        return new IdentifyDormitoryResponse();
    }

    /**
     * Create an instance of {@link IdentifyStudentStatus }
     * 
     */
    public IdentifyStudentStatus createIdentifyStudentStatus() {
        return new IdentifyStudentStatus();
    }

    /**
     * Create an instance of {@link IdentifyStudentStatusResponse }
     * 
     */
    public IdentifyStudentStatusResponse createIdentifyStudentStatusResponse() {
        return new IdentifyStudentStatusResponse();
    }

    /**
     * Create an instance of {@link Student }
     * 
     */
    public Student createStudent() {
        return new Student();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddStudentInfo }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddStudentInfo }{@code >}
     */
    @XmlElementDecl(namespace = "http://studentservice.com/", name = "addStudentInfo")
    public JAXBElement<AddStudentInfo> createAddStudentInfo(AddStudentInfo value) {
        return new JAXBElement<AddStudentInfo>(_AddStudentInfo_QNAME, AddStudentInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddStudentInfoResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddStudentInfoResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://studentservice.com/", name = "addStudentInfoResponse")
    public JAXBElement<AddStudentInfoResponse> createAddStudentInfoResponse(AddStudentInfoResponse value) {
        return new JAXBElement<AddStudentInfoResponse>(_AddStudentInfoResponse_QNAME, AddStudentInfoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ChangeStudentInfo }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ChangeStudentInfo }{@code >}
     */
    @XmlElementDecl(namespace = "http://studentservice.com/", name = "changeStudentInfo")
    public JAXBElement<ChangeStudentInfo> createChangeStudentInfo(ChangeStudentInfo value) {
        return new JAXBElement<ChangeStudentInfo>(_ChangeStudentInfo_QNAME, ChangeStudentInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ChangeStudentInfoResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ChangeStudentInfoResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://studentservice.com/", name = "changeStudentInfoResponse")
    public JAXBElement<ChangeStudentInfoResponse> createChangeStudentInfoResponse(ChangeStudentInfoResponse value) {
        return new JAXBElement<ChangeStudentInfoResponse>(_ChangeStudentInfoResponse_QNAME, ChangeStudentInfoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteStudentInfo }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DeleteStudentInfo }{@code >}
     */
    @XmlElementDecl(namespace = "http://studentservice.com/", name = "deleteStudentInfo")
    public JAXBElement<DeleteStudentInfo> createDeleteStudentInfo(DeleteStudentInfo value) {
        return new JAXBElement<DeleteStudentInfo>(_DeleteStudentInfo_QNAME, DeleteStudentInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteStudentInfoResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DeleteStudentInfoResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://studentservice.com/", name = "deleteStudentInfoResponse")
    public JAXBElement<DeleteStudentInfoResponse> createDeleteStudentInfoResponse(DeleteStudentInfoResponse value) {
        return new JAXBElement<DeleteStudentInfoResponse>(_DeleteStudentInfoResponse_QNAME, DeleteStudentInfoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStudentInfo }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetStudentInfo }{@code >}
     */
    @XmlElementDecl(namespace = "http://studentservice.com/", name = "getStudentInfo")
    public JAXBElement<GetStudentInfo> createGetStudentInfo(GetStudentInfo value) {
        return new JAXBElement<GetStudentInfo>(_GetStudentInfo_QNAME, GetStudentInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStudentInfoResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetStudentInfoResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://studentservice.com/", name = "getStudentInfoResponse")
    public JAXBElement<GetStudentInfoResponse> createGetStudentInfoResponse(GetStudentInfoResponse value) {
        return new JAXBElement<GetStudentInfoResponse>(_GetStudentInfoResponse_QNAME, GetStudentInfoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IdentifyByIdCard }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link IdentifyByIdCard }{@code >}
     */
    @XmlElementDecl(namespace = "http://studentservice.com/", name = "identifyByIdCard")
    public JAXBElement<IdentifyByIdCard> createIdentifyByIdCard(IdentifyByIdCard value) {
        return new JAXBElement<IdentifyByIdCard>(_IdentifyByIdCard_QNAME, IdentifyByIdCard.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IdentifyByIdCardResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link IdentifyByIdCardResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://studentservice.com/", name = "identifyByIdCardResponse")
    public JAXBElement<IdentifyByIdCardResponse> createIdentifyByIdCardResponse(IdentifyByIdCardResponse value) {
        return new JAXBElement<IdentifyByIdCardResponse>(_IdentifyByIdCardResponse_QNAME, IdentifyByIdCardResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IdentifyByStudentId }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link IdentifyByStudentId }{@code >}
     */
    @XmlElementDecl(namespace = "http://studentservice.com/", name = "identifyByStudentId")
    public JAXBElement<IdentifyByStudentId> createIdentifyByStudentId(IdentifyByStudentId value) {
        return new JAXBElement<IdentifyByStudentId>(_IdentifyByStudentId_QNAME, IdentifyByStudentId.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IdentifyByStudentIdResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link IdentifyByStudentIdResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://studentservice.com/", name = "identifyByStudentIdResponse")
    public JAXBElement<IdentifyByStudentIdResponse> createIdentifyByStudentIdResponse(IdentifyByStudentIdResponse value) {
        return new JAXBElement<IdentifyByStudentIdResponse>(_IdentifyByStudentIdResponse_QNAME, IdentifyByStudentIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IdentifyDepartment }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link IdentifyDepartment }{@code >}
     */
    @XmlElementDecl(namespace = "http://studentservice.com/", name = "identifyDepartment")
    public JAXBElement<IdentifyDepartment> createIdentifyDepartment(IdentifyDepartment value) {
        return new JAXBElement<IdentifyDepartment>(_IdentifyDepartment_QNAME, IdentifyDepartment.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IdentifyDepartmentResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link IdentifyDepartmentResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://studentservice.com/", name = "identifyDepartmentResponse")
    public JAXBElement<IdentifyDepartmentResponse> createIdentifyDepartmentResponse(IdentifyDepartmentResponse value) {
        return new JAXBElement<IdentifyDepartmentResponse>(_IdentifyDepartmentResponse_QNAME, IdentifyDepartmentResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IdentifyDormitory }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link IdentifyDormitory }{@code >}
     */
    @XmlElementDecl(namespace = "http://studentservice.com/", name = "identifyDormitory")
    public JAXBElement<IdentifyDormitory> createIdentifyDormitory(IdentifyDormitory value) {
        return new JAXBElement<IdentifyDormitory>(_IdentifyDormitory_QNAME, IdentifyDormitory.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IdentifyDormitoryResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link IdentifyDormitoryResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://studentservice.com/", name = "identifyDormitoryResponse")
    public JAXBElement<IdentifyDormitoryResponse> createIdentifyDormitoryResponse(IdentifyDormitoryResponse value) {
        return new JAXBElement<IdentifyDormitoryResponse>(_IdentifyDormitoryResponse_QNAME, IdentifyDormitoryResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IdentifyStudentStatus }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link IdentifyStudentStatus }{@code >}
     */
    @XmlElementDecl(namespace = "http://studentservice.com/", name = "identifyStudentStatus")
    public JAXBElement<IdentifyStudentStatus> createIdentifyStudentStatus(IdentifyStudentStatus value) {
        return new JAXBElement<IdentifyStudentStatus>(_IdentifyStudentStatus_QNAME, IdentifyStudentStatus.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IdentifyStudentStatusResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link IdentifyStudentStatusResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://studentservice.com/", name = "identifyStudentStatusResponse")
    public JAXBElement<IdentifyStudentStatusResponse> createIdentifyStudentStatusResponse(IdentifyStudentStatusResponse value) {
        return new JAXBElement<IdentifyStudentStatusResponse>(_IdentifyStudentStatusResponse_QNAME, IdentifyStudentStatusResponse.class, null, value);
    }

}
