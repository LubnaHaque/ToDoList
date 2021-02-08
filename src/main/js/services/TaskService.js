import axios from "axios";

const TASK_BASE_API_URL = "http://localhost:8080";

class TaskService{
    getTasks(){
        return axios.get(TASK_BASE_API_URL);
    }
}

export default new TaskService()