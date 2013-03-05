package smartsms



import org.junit.*
import grails.test.mixin.*

@TestFor(OpcionesController)
@Mock(Opciones)
class OpcionesControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/opciones/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.opcionesInstanceList.size() == 0
        assert model.opcionesInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.opcionesInstance != null
    }

    void testSave() {
        controller.save()

        assert model.opcionesInstance != null
        assert view == '/opciones/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/opciones/show/1'
        assert controller.flash.message != null
        assert Opciones.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/opciones/list'

        populateValidParams(params)
        def opciones = new Opciones(params)

        assert opciones.save() != null

        params.id = opciones.id

        def model = controller.show()

        assert model.opcionesInstance == opciones
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/opciones/list'

        populateValidParams(params)
        def opciones = new Opciones(params)

        assert opciones.save() != null

        params.id = opciones.id

        def model = controller.edit()

        assert model.opcionesInstance == opciones
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/opciones/list'

        response.reset()

        populateValidParams(params)
        def opciones = new Opciones(params)

        assert opciones.save() != null

        // test invalid parameters in update
        params.id = opciones.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/opciones/edit"
        assert model.opcionesInstance != null

        opciones.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/opciones/show/$opciones.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        opciones.clearErrors()

        populateValidParams(params)
        params.id = opciones.id
        params.version = -1
        controller.update()

        assert view == "/opciones/edit"
        assert model.opcionesInstance != null
        assert model.opcionesInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/opciones/list'

        response.reset()

        populateValidParams(params)
        def opciones = new Opciones(params)

        assert opciones.save() != null
        assert Opciones.count() == 1

        params.id = opciones.id

        controller.delete()

        assert Opciones.count() == 0
        assert Opciones.get(opciones.id) == null
        assert response.redirectedUrl == '/opciones/list'
    }
}
