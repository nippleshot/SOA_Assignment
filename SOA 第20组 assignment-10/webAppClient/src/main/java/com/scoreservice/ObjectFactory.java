
package com.scoreservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.scoreservice package. 
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

    private final static QName _AddScore_QNAME = new QName("http://scoreservice.com/", "addScore");
    private final static QName _AddScoreResponse_QNAME = new QName("http://scoreservice.com/", "addScoreResponse");
    private final static QName _DeleteScore_QNAME = new QName("http://scoreservice.com/", "deleteScore");
    private final static QName _DeleteScoreResponse_QNAME = new QName("http://scoreservice.com/", "deleteScoreResponse");
    private final static QName _FixScore_QNAME = new QName("http://scoreservice.com/", "fixScore");
    private final static QName _FixScoreResponse_QNAME = new QName("http://scoreservice.com/", "fixScoreResponse");
    private final static QName _GetClassAverage_QNAME = new QName("http://scoreservice.com/", "getClassAverage");
    private final static QName _GetClassAverageResponse_QNAME = new QName("http://scoreservice.com/", "getClassAverageResponse");
    private final static QName _GetScore_QNAME = new QName("http://scoreservice.com/", "getScore");
    private final static QName _GetScoreResponse_QNAME = new QName("http://scoreservice.com/", "getScoreResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.scoreservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AddScore }
     * 
     */
    public AddScore createAddScore() {
        return new AddScore();
    }

    /**
     * Create an instance of {@link AddScoreResponse }
     * 
     */
    public AddScoreResponse createAddScoreResponse() {
        return new AddScoreResponse();
    }

    /**
     * Create an instance of {@link DeleteScore }
     * 
     */
    public DeleteScore createDeleteScore() {
        return new DeleteScore();
    }

    /**
     * Create an instance of {@link DeleteScoreResponse }
     * 
     */
    public DeleteScoreResponse createDeleteScoreResponse() {
        return new DeleteScoreResponse();
    }

    /**
     * Create an instance of {@link FixScore }
     * 
     */
    public FixScore createFixScore() {
        return new FixScore();
    }

    /**
     * Create an instance of {@link FixScoreResponse }
     * 
     */
    public FixScoreResponse createFixScoreResponse() {
        return new FixScoreResponse();
    }

    /**
     * Create an instance of {@link GetClassAverage }
     * 
     */
    public GetClassAverage createGetClassAverage() {
        return new GetClassAverage();
    }

    /**
     * Create an instance of {@link GetClassAverageResponse }
     * 
     */
    public GetClassAverageResponse createGetClassAverageResponse() {
        return new GetClassAverageResponse();
    }

    /**
     * Create an instance of {@link GetScore }
     * 
     */
    public GetScore createGetScore() {
        return new GetScore();
    }

    /**
     * Create an instance of {@link GetScoreResponse }
     * 
     */
    public GetScoreResponse createGetScoreResponse() {
        return new GetScoreResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddScore }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddScore }{@code >}
     */
    @XmlElementDecl(namespace = "http://scoreservice.com/", name = "addScore")
    public JAXBElement<AddScore> createAddScore(AddScore value) {
        return new JAXBElement<AddScore>(_AddScore_QNAME, AddScore.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddScoreResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddScoreResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://scoreservice.com/", name = "addScoreResponse")
    public JAXBElement<AddScoreResponse> createAddScoreResponse(AddScoreResponse value) {
        return new JAXBElement<AddScoreResponse>(_AddScoreResponse_QNAME, AddScoreResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteScore }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DeleteScore }{@code >}
     */
    @XmlElementDecl(namespace = "http://scoreservice.com/", name = "deleteScore")
    public JAXBElement<DeleteScore> createDeleteScore(DeleteScore value) {
        return new JAXBElement<DeleteScore>(_DeleteScore_QNAME, DeleteScore.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteScoreResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DeleteScoreResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://scoreservice.com/", name = "deleteScoreResponse")
    public JAXBElement<DeleteScoreResponse> createDeleteScoreResponse(DeleteScoreResponse value) {
        return new JAXBElement<DeleteScoreResponse>(_DeleteScoreResponse_QNAME, DeleteScoreResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FixScore }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FixScore }{@code >}
     */
    @XmlElementDecl(namespace = "http://scoreservice.com/", name = "fixScore")
    public JAXBElement<FixScore> createFixScore(FixScore value) {
        return new JAXBElement<FixScore>(_FixScore_QNAME, FixScore.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FixScoreResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FixScoreResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://scoreservice.com/", name = "fixScoreResponse")
    public JAXBElement<FixScoreResponse> createFixScoreResponse(FixScoreResponse value) {
        return new JAXBElement<FixScoreResponse>(_FixScoreResponse_QNAME, FixScoreResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetClassAverage }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetClassAverage }{@code >}
     */
    @XmlElementDecl(namespace = "http://scoreservice.com/", name = "getClassAverage")
    public JAXBElement<GetClassAverage> createGetClassAverage(GetClassAverage value) {
        return new JAXBElement<GetClassAverage>(_GetClassAverage_QNAME, GetClassAverage.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetClassAverageResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetClassAverageResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://scoreservice.com/", name = "getClassAverageResponse")
    public JAXBElement<GetClassAverageResponse> createGetClassAverageResponse(GetClassAverageResponse value) {
        return new JAXBElement<GetClassAverageResponse>(_GetClassAverageResponse_QNAME, GetClassAverageResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetScore }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetScore }{@code >}
     */
    @XmlElementDecl(namespace = "http://scoreservice.com/", name = "getScore")
    public JAXBElement<GetScore> createGetScore(GetScore value) {
        return new JAXBElement<GetScore>(_GetScore_QNAME, GetScore.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetScoreResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetScoreResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://scoreservice.com/", name = "getScoreResponse")
    public JAXBElement<GetScoreResponse> createGetScoreResponse(GetScoreResponse value) {
        return new JAXBElement<GetScoreResponse>(_GetScoreResponse_QNAME, GetScoreResponse.class, null, value);
    }

}
