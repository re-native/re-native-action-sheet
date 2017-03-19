(ns re-native.action-sheet
  (:require [reagent.core :as r]
            [re-frame.core :as re]))

(def react-native-action-sheet (js/require "@exponent/react-native-action-sheet"))
(def connectActionSheet (aget react-native-action-sheet "connectActionSheet"))
(def ActionSheetProvider (aget react-native-action-sheet "ActionSheetProvider"))

(defn showActionSheetWithOptions [action-sheet options cb]
  (.showActionSheetWithOptions action-sheet options cb))

(def ActionSheet (aget react-native-action-sheet "default"))

(assert react-native-action-sheet)
(assert connectActionSheet)
(assert ActionSheetProvider)
(assert ActionSheet)

(defn show-action-sheet-with-options [action-sheet options cb]
  (showActionSheetWithOptions action-sheet
                              (clj->js options)
                              (fn show-action-sheet-with-options-cb [i]
                                (cb i))))

(def action-sheet-provider (r/adapt-react-class ActionSheetProvider))
(def action-sheet (r/adapt-react-class ActionSheet))
