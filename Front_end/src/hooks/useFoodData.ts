import { Food } from "../interface/FoodData";
import { useMutation, useQuery, useQueryClient } from "@tanstack/react-query";
import axios, { AxiosPromise } from "axios";

const API_URL: string = "http://localhost:8080";

const fetchData = async (): AxiosPromise<Food[]> => {
  const response = axios.get(API_URL + "/food");
  return response;
};

const postData = async (data: Food): AxiosPromise<Food> => {
  const response = axios.post(API_URL + "/food", data);
  return response;
};

export function useFoodData() {
  const query = useQuery({
    queryFn: fetchData,
    queryKey: ["food-data"],
    retry: 2,
  });

  return {
    ...query,
    data: query.data?.data,
  };
}

export function useFoodDataMutate() {
  const queryClient = useQueryClient();
  const mutate = useMutation({
    mutationFn: postData,
    retry: 2,
    onSuccess: () => {
      queryClient.invalidateQueries(["food-data"]);
    },
  });

  return mutate;
}
