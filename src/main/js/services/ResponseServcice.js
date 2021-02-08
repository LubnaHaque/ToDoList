class ResponseService{
    responsePayLoadToMap(axiosResponse){
        const status = axiosResponse.data.status;
        const payload = new Map(Object.entries(axiosResponse.data.payload));

        return{
            status: status,
            payload: payload
        }
    }
}

export default new ResponseService()