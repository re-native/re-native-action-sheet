(ns re-native.action-sheet-fx
  (:require [reagent.core :as r]
            [re-native.action-sheet :refer [show-action-sheet-with-options]]
            [re-frame.core :as re]))

(defonce action-sheet-ratom (r/atom nil))

(re/reg-fx
  :show-action-sheet
  (fn show-action-sheet [{:keys [options
                                 cancel-button-index
                                 destructive-button-index
                                 on-press]
                          :or   {options                  []
                                 cancel-button-index      0
                                 destructive-button-index 1
                                 on-press                 [:show-action-sheet-no-on-press]}}]
    (show-action-sheet-with-options
      @action-sheet-ratom
      {:options                options
       :cancelButtonIndex      cancel-button-index
       :destructiveButtonIndex destructive-button-index}
      (fn show-action-sheet-with-options-cb [i] (re/dispatch (conj on-press i))))))
