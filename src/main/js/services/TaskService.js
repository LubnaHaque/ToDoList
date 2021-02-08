import axios from "axios";

const TASK_BASE_API_URL = "http://localhost:8080/api/task";

class TaskService{
    getAllTasks(){
        return axios.get(TASK_BASE_API_URL);
    }
}

export default new TaskService()